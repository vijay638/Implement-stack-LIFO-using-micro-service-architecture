# Implement-stack-LIFO-using-micro-service-architecture---> Implemented two microservices

       1) StackImplementation-service
            Exposed PUSH & POP REST API
               PUSH : @GetMapping("/push/{data}")
                POP  : @GetMapping("/pop")
         StackImplementation-service calls the PUSH and POP Rest APIs of stack-push-pop-service

      2) stack-push-pop-service :
          Exposed PUSH & POP REST API
                PUSH :   @GetMapping("/stackOperation/push/{data}")
                POP  :   @GetMapping("/stackOperation/pop/")
            This service connects to PostgreSQL DB 

---> deployed both above two microservices in minikube environment using docker and Kubernetes tools
---> Documented using Swagger  (http://host:port/v2/api-docs)
---> Docker-compose tested.


After deployement of services on minikube
you should the apis as below

http://${minikube ip}:30163/StackImlementation/push/{data}
http://${minikube ip}:30163/StackImlementation/pop


