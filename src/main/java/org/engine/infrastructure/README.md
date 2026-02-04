# 🏗️ Infrastructure Layer - Audit Logging

Este módulo é responsável pela **rastreabilidade total** das ações realizadas dentro do ecossistema. Diferente de logs de erro comuns, o `AuditLogger` foca em manter um histórico imutável e detalhado de eventos críticos para auditoria, segurança e conformidade.

## 📝 O que é Audit Logging?

O `AuditLogger.java` registra modificações de estado, acessos a dados sensíveis e execuções de comandos de alto nível. É a prova técnica de que o sistema está operando conforme as regras de negócio e de que todas as ações são rastreáveis até a sua origem.

## 🚀 Funcionalidades

* **Trilha de Auditoria (Audit Trail)**: Registro cronológico detalhado contendo: *Quem realizou a ação*, *O que foi alterado*, *Quando ocorreu* e *Qual era o estado anterior*.
* **Persistência de Provas**: Logs formatados para garantir a integridade da informação, prontos para auditorias externas ou análises de segurança.
* **Não-Repúdio**: Implementa mecanismos que garantem que uma ação realizada no sistema possa ser comprovada e verificada posteriormente.

---

## 🛠️ Aplicação em Projetos Freelance

Em sistemas corporativos e financeiros, a auditoria é um requisito de **Compliance** e segurança. Ter um `AuditLogger` robusto permite:
1.  **Transparência Total**: Oferece ao cliente a capacidade de auditar cada centavo movimentado ou cada configuração alterada no sistema.
2.  **Diagnóstico Avançado**: Facilita a identificação de comportamentos inesperados ou erros de operação humana.
3.  **Segurança**: Monitora acessos a áreas restritas, servindo como uma camada de proteção contra abusos internos ou externos.

---

## 🏗️ Princípios de Design

1.  **Imutabilidade**: Os registros de auditoria são tratados como dados de "somente leitura" após a criação, garantindo que o histórico não seja manipulado.
2.  **Baixo Acoplamento**: O logger de auditoria é agnóstico à regra de negócio, capturando apenas os eventos disparados pela camada de domínio.
3.  **Segregação de Logs**: Separa logs operacionais (telemetria) de logs de auditoria (negócio), otimizando a busca e a organização dos dados.

---

## 🚀 Por que isso é importante?
A presença de um sistema de auditoria em um repositório demonstra que o desenvolvedor projeta softwares prontos para o **mundo corporativo**. Isso mostra que você não se preocupa apenas com o "código que funciona", mas com a segurança, a responsabilidade sobre os dados e a transparência para o cliente final.
