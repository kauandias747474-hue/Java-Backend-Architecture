# 🛡️ Infrastructure Security Layer | Camada de Segurança de Infraestrutura

## 🇧🇷 Português

### 📌 Objetivo
Esta camada é a primeira linha de defesa da aplicação. Ela não lida com regras de negócio, mas sim com a proteção da infraestrutura contra ataques externos, abusos de API e corrupção de dados.

### 🚀 Componentes de Defesa Ativa
* **`RateLimiter.java`**: Controla a vazão de requisições por usuário ou IP. Utiliza algoritmos de controle de tráfego para prevenir ataques de negação de serviço (DoS) e proteger os recursos do Home Server.
* **`SecurityInterceptor.java`**: Atua como um "vigilante" no pipeline de entrada. Ele intercepta todas as chamadas para validar tokens, higienizar inputs e injetar contextos de segurança antes que a requisição chegue aos motores principais.
* **`audit/`**: (Cadeia Imutável) Garante que qualquer dado escrito seja vinculado criptograficamente ao registro anterior, impedindo alterações retroativas no banco de dados.

---

## 🇺🇸 English

### 📌 Purpose
This layer is the application's first line of defense. It focuses on infrastructure protection against external attacks, API abuse, and data corruption, rather than business logic.

### 🚀 Active Defense Components
* **`RateLimiter.java`**: Controls request throughput per user or IP. It implements traffic control algorithms to prevent Denial of Service (DoS) attacks and protect Home Server resources.
* **`SecurityInterceptor.java`**: Acts as a "sentinel" in the input pipeline. It intercepts all calls to validate tokens, sanitize inputs, and inject security contexts before the request reaches the core engines.
* **`audit/`**: (Immutable Chain) Ensures that every written record is cryptographically linked to the previous one, preventing retroactive database tampering.
