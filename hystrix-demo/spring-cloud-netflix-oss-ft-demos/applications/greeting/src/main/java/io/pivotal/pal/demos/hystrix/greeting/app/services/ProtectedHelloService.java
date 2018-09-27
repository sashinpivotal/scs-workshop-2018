package io.pivotal.pal.demos.hystrix.greeting.app.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.pivotal.pal.demos.hystrix.greeting.services.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtectedHelloService implements HelloService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final HelloService primaryHelloService;
    private final HelloService backupHelloService;
    private final HelloService falloutHelloService;

    public ProtectedHelloService(HelloService primaryHelloService,
                                 HelloService backupHelloService,
                                 HelloService falloutHelloService) {
        this.primaryHelloService = primaryHelloService;
        this.backupHelloService = backupHelloService;
        this.falloutHelloService = falloutHelloService;
    }

    @HystrixCommand(commandKey = "sayHelloCmd",
            threadPoolKey = "sayHelloThreadPool",
            fallbackMethod = "backupSayHello")
    @Override
    public String sayHello() {
        logger.debug("sayHello()");
        return primaryHelloService.sayHello();
    }

    @HystrixCommand(commandKey = "backupSayHelloCmd",
            fallbackMethod = "falloutSayHello")
    public String backupSayHello() {
        logger.debug("backupSayHello()");
        return backupHelloService.sayHello();
    }

    @HystrixCommand(commandKey = "falloutSayHelloCmd")
    public String falloutSayHello() {
        logger.debug("falloutSayHello()");
        return falloutHelloService.sayHello();
    }
}
