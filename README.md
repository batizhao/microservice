# microservice
使用 Spring Cloud, Spring Boot, Activiti 等技术实现一个小型的OA系统。

## flow-engine-server

### 启动流程

在未使用 Eureka 之前
``` 
$ curl -u admin:admin -H "Content-Type: application/json" -d '{"name":"John Doe", "email": "john.doe@alfresco.com", "phoneNumber":"123456789"}' http://localhost:8000/start-process
```

在使用 Eureka 之后
``` 
$ curl -u admin:admin -H "Content-Type: application/json" -d '{"name":"John Doe", "email": "john.doe@alfresco.com", "phoneNumber":"123456789"}' http://discovery:8080/start-process
```