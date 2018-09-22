# Spring Cloud Developer Workshop

Tips, errors in the lab documents, etc will be posted here by the instructors.

## Service Discovery

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