# 🧼 Infrastructure - Data Sanitization

Este módulo foca na higiene dos dados de entrada. O `InputCleaner.java` atua como um filtro de segurança, garantindo que nenhum dado malicioso ou mal formatado entre nas camadas de processamento do sistema.

## 📝 O que é Sanitização?

Sanitização é o processo de limpar entradas de usuários ou sistemas externos. Ela remove caracteres perigosos, scripts maliciosos (XSS) e tentativas de injeção de código, transformando "lixo" em dados seguros.

## 🚀 Funcionalidades

* **Limpeza de Strings**: Remove espaços desnecessários, tags HTML indesejadas e caracteres especiais perigosos.
* **Prevenção de Injeção**: Garante que os dados enviados para o banco de dados ou logs estejam devidamente escapados.
* **Normalização**: Padroniza os dados para que a lógica de negócio receba sempre o formato esperado.

## 💡 Impacto no Projeto
Um sistema sanitizado é um sistema estável. Ao implementar o `InputCleaner`, você evita bugs imprevisíveis e protege a infraestrutura do cliente contra as formas mais comuns de exploração de vulnerabilidades.
