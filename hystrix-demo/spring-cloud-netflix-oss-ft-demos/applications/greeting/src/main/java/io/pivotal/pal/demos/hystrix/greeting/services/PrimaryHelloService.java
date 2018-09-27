package io.pivotal.pal.demos.hystrix.greeting.services;

import io.pivotal.pal.demos.hystrix.greeting.clients.FortuneServiceClient;

public class PrimaryHelloService extends AbstractHelloService {
    public final FortuneServiceClient fortuneServiceClient;

    public PrimaryHelloService(FortuneServiceClient
                                       fortuneServiceClient,
                               boolean fortuneEnabled) {
        super(fortuneEnabled);
        this.fortuneServiceClient = fortuneServiceClient;
    }

    @Override
    String getFortune() {
        return fortuneServiceClient.getFortune();
    }

    @Override
    String getHelloMsg() {
        return "Hello, I am the Prime!";
    }
}
