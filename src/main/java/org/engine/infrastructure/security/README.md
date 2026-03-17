# 🛡️ Infrastructure Security Layer | Camada de Segurança de Infraestrutura

## 🇧🇷 Português



###  Objetivo
Proteger o Home Server contra ataques de negação de serviço (DoS) e garantir a integridade dos dados de entrada através de uma arquitetura de **Defesa Ativa**.

###  Componentes Técnicos
1. **RateLimiter.java (Híbrido):** - **Filtragem de Estado:** Busca instantânea ($O(1)$) em Blacklist via `ConcurrentHashMap.newKeySet()`.
   - **Controle de Vazão:** Monitoramento de frequência usando `AtomicInteger` para precisão multithread.
   - **Promoção de Punição:** Transfere automaticamente agressores do monitoramento temporário para o bloqueio permanente.
2. **SecurityInterceptor.java (Sentinela):** - Atua como o "vigilante" do pipeline. Valida tokens e sanitiza payloads.
   - **Conexão Ativa:** Possui autoridade para ordenar ao `RateLimiter` o bloqueio imediato de IPs que enviem dados maliciosos (SQL Injection/XSS).

###  Lógica de Programação
O sistema opera em **Curto-Circuito (Fail-Fast)**. A primeira verificação é sempre a mais barata computacionalmente (Blacklist). A lógica de "Promoção" garante que um agressor frequente seja purgado da memória RAM de contadores e movido para uma assinatura estática, economizando recursos do servidor.

---

## 🇺🇸 English

###  Purpose
Shield the Home Server against Denial of Service (DoS) attacks and ensure input data integrity through an **Active Defense** architecture.

###  Technical Components
1. **RateLimiter.java (Hybrid):** - **State Filtering:** Instant $O(1)$ lookup in Blacklist via `ConcurrentHashMap.newKeySet()`.
   - **Throughput Control:** Frequency monitoring using `AtomicInteger` for multi-threaded accuracy.
   - **Punishment Promotion:** Automatically transfers offenders from temporary monitoring to permanent blocking.
2. **SecurityInterceptor.java (Sentinel):** - Acts as the pipeline "sentinel". Validates tokens and sanitizes payloads.
   - **Active Connection:** Authorized to command the `RateLimiter` to immediately block IPs sending malicious data (SQL Injection/XSS).

###  Implementation Logic
The system operates on a **Short-Circuit (Fail-Fast)** basis. The first check is always the computationally cheapest (Blacklist). The "Promotion" logic ensures that a frequent attacker is purged from RAM counters and moved to a static signature, saving server resources.

---
