

import java.util.UUID;

interface UserRepository {
     long count();
     void save(User user);
 }


 interface PasswordEncoder {
     String encode(String rawPassword);
 }


 class User {
    private final String name;
    private final String email;
    private final String password;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public String getName() { return name; }

     public String getEmail() { return email; }

     public String getPassword() { return password; }
 }

  class DatabaseSeeder {
     private final UserRepository userRepository;
     private final PasswordEncoder  passwordEncoder;

     public DatabaseSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
         this.userRepository = userRepository;
         this.passwordEncoder = passwordEncoder;
     }

     public void seed() {
         String sessionID = UUID.randomUUID().toString().substring(0, 8);
         long start = System.currentTimeMillis();

         System.out.println("🔍 [Sessão: " + sessionID + "] DatabaseSeeder: Verificando integridade...");

         if (userRepository.count() == 0) {
             String defaultPassword = System.getenv("ADMIN_PASSWORD");
             if (defaultPassword == null) defaultPassword = "admin_default_123";

             String encodedPassword = passwordEncoder.encode(defaultPassword);
             User admin = new User("admin", "admin@sistema.com", encodedPassword);


             userRepository.save(admin);

             long elapsed = System.currentTimeMillis() - start;

             System.out.println("✅ [Sessão: " + sessionID + "] Admin (" + admin.getEmail() + ") semeado!");
             System.out.println("🔑 Hash da senha: " + admin.getPassword().substring(0, 10) + "...");
             System.out.println("⏱️ Tempo total: " + elapsed + "ms");

         } else {
             try {
                 System.out.println("⏳ Aguardando 3 segundos...");
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             }
             System.out.println("ℹ️ [Sessão: " + sessionID + "] Banco já populado.");
         }
     }
  }
  class Main {
   static void main() {

         UserRepository repo = new UserRepository() {
             @Override
             public long count() {
                 return 1;
             }

             @Override
             public void save(User u) {
                 System.out.println("💾 Simulando banco: " + u.getName() + "guardado. ");
             }
         };

         PasswordEncoder encoder = (raw) -> "hash_" + raw;

         DatabaseSeeder seeder = new DatabaseSeeder(repo, encoder);
         seeder.seed();

       }
   }
