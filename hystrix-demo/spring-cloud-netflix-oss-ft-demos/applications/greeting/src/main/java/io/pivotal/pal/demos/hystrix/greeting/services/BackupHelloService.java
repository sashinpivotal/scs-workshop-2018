package io.pivotal.pal.demos.hystrix.greeting.services;

public class BackupHelloService extends AbstractHelloService {

    public BackupHelloService(boolean fortuneEnabled) {
        super(fortuneEnabled);
    }

    @Override
    String getFortune() {
        return "You are a Rock Star!";
    }

    @Override
    String getHelloMsg() {
        return "Hello, I am the Backup!";
    }
}
