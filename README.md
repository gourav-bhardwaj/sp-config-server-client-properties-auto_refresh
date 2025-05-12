# 🌐 Spring Cloud Config Server with Kafka-based Auto Refresh

This project demonstrates how to build a centralized configuration management system using **Spring Cloud Config Server**, **Kafka**, and **GitHub Webhooks**. Config changes in the Git repository are automatically propagated to all client services using **Spring Cloud Bus with Kafka**.

---

## 📌 Features

- Centralized configuration for microservices
- Git-based property management
- Real-time configuration updates using GitHub Webhooks
- Auto-refresh client configs using Spring Cloud Bus (Kafka)
- Scalable and production-ready setup

---

## 🏗️ Architecture

```
GitHub (config repo)
        │
        ▼
GitHub Webhook → Spring Config Server (via /monitor)
        │
        ▼
Spring Cloud Bus (Kafka)
        │
        ▼
Spring Boot Clients (auto-refresh configs)
```

---

## ⚙️ Prerequisites

- Java 17+
- Maven
- Docker (for Kafka and Zookeeper)
- Ngrok (to expose local server to GitHub)
- A GitHub repo containing your config files (e.g., `application.yml`)

---

## 🚀 Setup Instructions

### 1. Start Kafka & Zookeeper (Docker)

```bash
docker-compose -f kafka-docker-compose.yml up -d
```

---

### 2. Expose Config Server via Ngrok

```bash
ngrok http 8888
```

> Note down the generated HTTPS forwarding URL (e.g., `https://abc123.ngrok-free.app`).

---

### 3. Configure GitHub Webhook

In your GitHub **config repository**:

- Go to **Settings → Webhooks → Add webhook**
- **Payload URL**:  
  `https://<ngrok-id>.ngrok-free.app/monitor?path=application`
- **Content Type**: `application/x-www-form-urlencoded`
- Enable SSL
- Trigger on `Just the push event`

---

### 4. Run the Config Server

```bash
mvn spring:run -Dspring-boot.run.jvmArguments="\
-DGIT_REPO=https://github.com/<your-org>/config-repo.git \
-DGIT_USERNAME=<your-username> \
-DGIT_PASSWORD=<your-password>"
```

---

### 5. Run the Config Client(s)

```bash
cd config-client
mvn spring-boot:run
```

---

### 6. Test Auto Refresh

1. Change any value in the GitHub config repo (e.g., `application.yml`)
2. Commit and push
3. The webhook will notify the Config Server
4. Config Server publishes an update event to Kafka
5. All Config Clients receive and refresh the config automatically 🎉

---

## 🧪 Example Property

```yaml
# application.yml (in GitHub repo)
custom:
  message: Hello from central config!
```

You can expose this in your client controller:

```java
@Value("${custom.message}")
private String message;
```

---

## 📦 Tech Stack

- Spring Boot
- Spring Cloud Config Server & Client
- Spring Cloud Bus with Kafka
- GitHub Webhooks
- Docker
- Ngrok

---

## 🙋 Why Use This?

Managing config across 10–20+ microservices can be a nightmare. This setup automates and centralizes configuration delivery with zero manual effort — scalable, maintainable, and ideal for production environments.
