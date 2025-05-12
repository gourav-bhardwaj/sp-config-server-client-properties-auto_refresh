# Config server & Client with Auto refresh feature using kafka
Spring config server is used to make your configuration centralized, which can be used by multiple applications, and client properties are automatically refreshed using a git webhook. The webhook endpoint, which we're configuring, belongs to the config-server.

Follow the steps:

1. Create a global endpoint using ngrok for the config-server

```sh
ngrok http http://localhost:8888
```

Copy the forwarding URL mapping with your local URL - https://ngrok-free.app -> http://localhost:8888

2. Configure the GitHub webhook in the repository where the properties are stored:
   Setting > Webhook
     Path: https://ngrok-free.app/monitor?path=application
     Content-Type: application/x-www-form-urlencoded

3. Run your Docker Desktop
4. Now run the config-server using the below command
```sh

```
   


 
