# 🔍 Discovery Server (Netflix Eureka)
**Pilar:** Infraestrutura Distribuída

O cérebro da orquestração que permite que os microserviços se comuniquem sem endereços IP estáticos (Service Discovery).

### 🛠️ Funções Core
- **Service Registry:** Registro em tempo real de todas as instâncias ativas.
- **Health Monitoring:** Monitoramento de status (UP/DOWN) integrado ao `CircuitBreaker`.
- **High Availability:** Configurado para suportar escalabilidade horizontal via Docker/Kubernetes.
