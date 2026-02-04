# 🚪 API Gateway Service
**Pilar:** Segurança de Borda & Roteamento Centralizado

Este componente atua como o **Single Point of Entry** (Ponto Único de Entrada) do sistema. Ele é responsável por filtrar todas as requisições antes que cheguem aos motores de cálculo.

### 🛡️ Hardening & Security Features
- **Rate Limiting:** Implementação anti-DoS para proteger os microserviços de exaustão de recursos.
- **Request Sanitization:** Filtro global contra SQL Injection e XSS.
- **Correlation ID Injection:** Garante que toda requisição receba um ID único para rastreabilidade no `ContextInterceptor`.

### ⚙️ Responsabilidades
- Roteamento dinâmico para serviços via Discovery Server.
- Terminação TLS/SSL.
- Autenticação centralizada.
