# Spring Cloud Developer Workshop

Due to time constraint, we will not cover the following topics.  Please feel
free to explore them on your own, however, especially if you finish the lab 
exercises earlier than others.

- Introduction: 
  -   Spring Cloud Dependencies
- Service Discovery: 
  -   Eureka Server REST Operations
- Fault Tolerance: 
  -   Hystrix Stats Aggregation
- Config Server: 
  -   Distributed Updates
  -   Vault Backend
- Additional Topics:
  -   Feign
  -   Distributed Trace - Sleuth
  -   Distributed Trace - Zipkin

## Service Discovery

### Application Continuum

-   Instead of using "curl" as following:

    ```
    curl -i -XPOST -H"Content-Type: application/json" localhost:8084/time-entries/ -d"{\"projectId\": 1, \"userId\": 1, \"date\": \"2015-05-17\", \"hours\": 6}"
    ```
    You can use "httpie" as following:
    
    ```
    http post localhost:8084/time-entries projectId=1 userId=1 date=2015-05-17  hours=6
    ```

### Eureka Service Registry

-   Unlike IntelliJ, Eclipse/STS will not display the 
    mult-module project 
    in the "easy to understand" hierarchical fashion.  Just
    choose correct directory.
    
-   If you experience the following problem when running Eureka
    server, please use JDK 8 instead of JDK 9+. 
    
    ```
    Exception in thread "main" java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
    ``` 
    
    Or add the following dependency to the build.gradle.
    
    ```
    compile "javax.xml.bind:jaxb-api:2.3.0"
    ```
    
## Fault Tolerance

### Hystrix Isolation Stratgies 

-   There is an error in the “application.properties” file
    of the "timesheets-server". Change it to 5000. (Leaving it
    2000 will not change the outcome of the lab, however.)
    
    ```
    # requests that take more than 5 seconds will “fail fast”:
    hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000
    ```