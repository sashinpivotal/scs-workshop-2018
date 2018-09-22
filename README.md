# Spring Cloud Developer Workshop

## Logistics (day 1)

-   Introduction of Instructors 
    -   Sang Shin (sashin@pivotal.io)
    -   Alan McGinlay (amcginlay@pivotal.io)
-   Introduction of Proctors
    -   Anand Rao (arao@pivotal.io)
    -   Tej Tenmattam (ttenmattam@pivotal.io)
    -   Alberto Rios (arios@pivotal.io) 
-   Polling on Students Background
    -   How many of you have been working on Java programming more than 
        1 year, 3 years, 5 years?
    -   How many of you have worked with Spring, Spring Boot?
    -   How many of you have worked with PAAS platforms such as Cloud Foundry
        or Kubernetics?
-   Workshop starts at 9AM and ends at 5PM
    -   Two 20 minutes breaks, one in the morning and one in the afternoon
    -   Lunch is 1 hour starting from ??

## Workshop Agenda

Due to time constraint, the current plan is not cover the following topics. 
(This could change if we are moving faster than the plan.) 

- Introduction: 
  -   Spring Cloud Dependencies
- Service Discovery (and Client-side Load Balancing): 
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

### Application Continuum (Lab)

-   Instead of using "curl" as following:

    ```
    curl -i -XPOST -H"Content-Type: application/json" localhost:8084/time-entries/ -d"{\"projectId\": 1, \"userId\": 1, \"date\": \"2015-05-17\", \"hours\": 6}"
    ```
    You can use "httpie" as following:
    
    ```
    http post localhost:8084/time-entries projectId=1 userId=1 date=2015-05-17  hours=6
    ```
    
-   If you are using Ultimate Edition IntelliJ or STS, you might as well take
    advantage of "Spring Boot Dashboard", which makes running multiple applications
    easier to deal with.
    
-   If you are a Windows user and decided to use "cmd" terminal window for
    running apps, you might consider to use [ConEMU](https://conemu.github.io/) instead

### Eureka Service Registry (Lab)

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

### Hystrix Isolation Stratgies (Lab)

-   There is an error in the “application.properties” file
    of the "timesheets-server". Change it to 5000. (Leaving it
    2000 will not change the outcome of the lab, however.)
    
    ```
    # requests that take more than 5 seconds will “fail fast”:
    hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000
    ```
    
### Hystrix Stats Aggregation (Lab - Optional)

-   The command to start RabbitMQ is "rabbitmq-server".

## Config Server

### Distributed Updates (lab - Optional)

-   The RabbitMQ management and trace plugins can be installed as following:

    ```
    sudo rabbitmq-plugins enable rabbitmq_management
    sudo rabbitmq-plugins enable rabbitmq_tracing
    ```

## Additional Topics

### Distributed Trace - Zipkin (Lab - Optional)

-   Even though the document says the following:

    ```
    git checkout -b my-zipkin-start zipkin-start
    ```
    
    There is no "zipkin-start" tag provided.  Please use the "solution" codebase of 
    "Distributed Trace - Sleuth".
    
    You will also need to download and run "zipkin.jar" using the following instruction
    
    ```
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
    java -jar zipkin.jar
    ```
    
  