package io.pivotal.pal.demos.hystrix.greeting.app.controllers;

import io.pivotal.pal.demos.hystrix.greeting.services.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController implements HelloService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final HelloService service;

    public GreetingController(HelloService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public String sayHello() {
        logger.debug("GET execute sayHello()");

        return service.sayHello();
    }
}
