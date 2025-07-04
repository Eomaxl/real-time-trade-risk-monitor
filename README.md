# Real-Time Trade Risk Monitor using FIX + Java

<b>Overview :</b><br>
Building a system that monitors live FIX messages (order & executions) and flags any violations of predefined risk rules, such as:
-   Large order size
- Orders placed outside working hours
- Orders for restricted instruments
- Exceeded cumulative notional exposure per account

<b>Components :</b><br>
1. FIX Acceptor using QuickFIX/J
- Simulates receiving order and execution messages from traders

2. Risk Rule Engine
- Java service that applies risk checks on incoming messages
- Example rules:
  - OrderQuantity > 10,000 → flag
  - Instrument = "TSLA" → restricted
  - ExecutionTime > 16:00 UTC → after market close

3. Violation Reporter
- Store flagged trades in a database (PostgreSQL)
- Send alert via console or REST API (could be integrated with Slack/email later)

4. Audit Dashboard (Optional)
- Use Spring Boot + React to view flagged trades, live order flow


##  High-Level Scalable Architecture – Trade Risk Monitor

Components :<br>
- Traders : Sends real-time trade orders using FIX protocol
- QuickFIX/J Acceptor : Listens for FIX messages (orders, executions) from traders
- Risk Checker Service : Applies business rules to detect risk violations
- Violation Store : Persists flagged trades (PostgreSQL or Cloud SQL)
- Alert Service : Sends alerts to admin (e.g., console logs, web UI, email, Slack)
- UI Dashboard : Displays live flagged messages and historical violations
- Kubernetes (GKE/EKS) : Orchestrates containerized microservices
- Cloud Pub/Sub or kafka : Optional message bus for decoupling FIX ingestion and rule evaluation

##  Deployment & Infra Breakdown
Components:
- Trader Simulator -> Java / Python / FIX simulator -> Sends FIX 4.2/4.4 messages
- FIX Acceptor -> QuickFIX/J + Spring Boot -> Stateless, containerized
- Risk Checker -> Java (Spring Boot) -> Consumes FIX or decoded message
- Message Queue (optional) -> Kafka / Google PubSub -> For buffering or scaling out rules
- Violation Store -> PostgreSQL / CloudSQL -> Stores risk logs
- Alert Service -> Spring Boot / Node.js / webhook -> Sends alerts
- UI Dashboard -> React + Tailwind + WebSocket -> Real-time monitoring
- Infrastructure -> GCP GKE / AWS EKS, CloudSQL, PubSub -> Managed services recommended
- Observability -> Prometheus + Grafana / Datadog -> Metrics & alerting
- Secrets & Configs -> GCP Secret Manager / AWS Parameter Store -> For storing credentials

## Kubernetes Deployment Strategy
- Each component is Dockerized and deployed as a separate pod.
- Use Helm Charts or Kustomize for configuration management.
- Use Horizontal Pod Autoscaler (HPA) for FIX Acceptor and Risk Checker to auto-scale based on CPU/network.
- Use ConfigMaps for runtime FIX config and Secrets for DB passwords, SSL keys.

## Communication Channels
- Trader → FIX Acceptor | FIX/TCP | Incoming trade order messages
- FIX Acceptor → Risk Checker | HTTP/Kafka/gRPC | Transmit decoded FIX orders
- Risk Checker → Store | JDBC | Log flagged violations
- Risk Checker → Alert | REST/Webhook | Push alert events
- Alert Store → UI | WebSocket/REST | Push live alert view
- UI → Store | REST API | Historical violation queries

## Security and Fault Tolerance
- mTLS / SSL between FIX Client and Acceptor.
- Circuit breakers & retry logic in Risk Checker.
- FIX message persistence via Kafka if real-time processing fails.
- RBAC on Kubernetes + IAM roles on GCP/AWS.
- Auto-scaling and self-healing via Kubernetes Deployments + HPA.

## Scalability Considerations
- Scale Risk Checker horizontally (stateless).
- Use Kafka to decouple ingestion and processing.
- Split rule evaluation into sub-modules or services for complex scenarios.
- Introduce caching (Redis) for account/instrument limit lookups.

