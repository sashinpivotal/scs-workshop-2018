# Spring Cloud Developer Workshop

## Logistics and Introduction (day 1)

-   Introduction of Instructors 
    -   Sang Shin [sashin@pivotal.io](mailto:sashin@pivotal.io)
    -   Alan McGinlay [amcginlay@pivotal.io](mailto:amcginlay@pivotal.io)
-   Introduction of Proctors
    -   Anand Rao [arao@pivotal.io](mailto:arao@pivotal.io)
    -   Tej Tenmattam [ttenmattam@pivotal.io](mailto:ttenmattam@pivotal.io)
    -   Alberto Rios [arios@pivotal.io](mailto:arios@pivotal.io) 
-   Polling on Students Background
    -   How many of you have been working on Java programming more than 
        1 year, 3 years, 5 years?
    -   How many of you have worked with Spring, Spring Boot?
    -   How many of you have worked with PAAS platforms such as Cloud Foundry
        or Kubernetics?
-   Workshop starts at 9AM and ends at 5PM
    -   Two 15 minutes breaks, one in the morning and one in the afternoon
    -   Lunch is 1 hour around noon
-   Pair Programming is encouraged
    -   Share knowledge

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

-   You are standing up Eureka Server as a Spring Boot application from
    scratch.  So you will have to create `src/main/java` directory first before
    creating `io.pivotal.pal.tracker.eurekaserver.EurekaServerApp.java`
    
    Same for creating `application.yml`. You will have to create 
    `src/main/resources` directory first before creating `application.yml`
    underneath it.
    
-   Unlike IntelliJ, Eclipse/STS will not display the 
    mult-module project 
    in a "easy to understand" hierarchical fashion. Instead, it will
    display all projects in "flat" directory style. Just
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
    
### Service Discovery Client (Lab)

-   Note that there are three different ways to create discovery client
    -   Using `ServiceLocator` interface and `EurekaServiceLocator` 
        implementation class (lab)
    -   Using `DiscoveryClient` (challenge lab exercise)
    -   Using `@LoadBalanced` annotation with `RestTemplate` (in the subsequent lab)
    
## Fault Tolerance

### Hystrix Isolation Stratgies (Lab)

-   There is an comment error in the “application.properties” file
    of the "timesheets-server". Leave the value as it is.
    
    ```
    # requests that take more than 5 seconds will “fail fast”:
    hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000
    ```
    
### Hystrix Stats Aggregation (Lab - Optional)

-   The command to start RabbitMQ is "rabbitmq-server".

## Config Server

### Valut Backend

-   Verison 0.10.x introduces breaking changes.
    Install an older compatible version from [https://releases.hashicorp.com/vault/0.9.6/](https://releases.hashicorp.com/vault/0.9.6/)
    Choose the correct version for your OS, unzip the binary, and copy onto the path (e.g. /usr/local/bin)

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
    
  
