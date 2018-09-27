package io.pivotal.pal.demos.hystrix.greeting.services;

public class FalloutHelloService extends AbstractHelloService {

    public FalloutHelloService(boolean fortuneEnabled) {
        super(fortuneEnabled);
    }

    @Override
    String getFortune() {
        return "You are a Rock Star!";
    }

    @Override
    String getHelloMsg() {
        return "Hello, I am the Sweeper!";
    }
}
