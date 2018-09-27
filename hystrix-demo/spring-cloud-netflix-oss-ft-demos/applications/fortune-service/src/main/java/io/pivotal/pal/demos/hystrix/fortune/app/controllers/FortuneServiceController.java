package io.pivotal.pal.demos.hystrix.fortune.app.controllers;

import io.pivotal.pal.demos.hystrix.fortune.services.FortuneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneServiceController implements FortuneService {
    private final FortuneService fortuneService;

    public FortuneServiceController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
