# Config server & Client with Auto refresh feature using kafka
Spring config server is used to make your configuration centralized, which can be used by multiple applications, and client properties are automatically refreshed using a git webhook. The webhook endpoint, which we're configuring, belongs to the config-server.

Follow the steps:

1. Create a global endpoint using ngrok for the config-server
```sh
ngrok http http://localhost:8888
```

2. Copy the forwarding URL mapping with your local URL - https://ngrok-free.app -> http://localhost:8888

3. Configure the GitHub webhook in the repository where the properties are stored:
   Setting > Webhook
     Path: https://ngrok-free.app/monitor?path=application
     Content-Type: application/x-www-form-urlencoded
     Enable SSL
     The event hit on push

4. Run your Docker Desktop

5. Now run the config-server using the below command
```sh
mvn spring:run -Dspring-boot.run.jvmArguments="-DGIT_REPO=... -DGIT_USERNAME=... -DGIT_PASSWORD=..."
```

6. Run the config-client using the below command
```sh
mvn spring-boot:run
```

7. Update any property from the GIT repository that contains properties.

8. It will hit the webhook endpoint of the config-server, and all config-clients application properties will be updated automatically.

Aren't you surprised!

Suppose you have 10 to 20 microservices in an architecture, and we're using databases, caches, and third-party APIs, then any configuration change you want to do in that case, you need to visit every microservice, which is a very troublesome task. So, to resolve this issue, created a centralized properties auto-configure feature using Kafka.  
   


 
