package io.pivotal.pal.demos.hystrix.greeting.services;

import io.pivotal.pal.demos.hystrix.failure.instrument.InstrumentForFailure;

public abstract class AbstractHelloService implements HelloService {
    private final boolean fortuneEnabled;

    public AbstractHelloService(boolean fortuneEnabled) {
        this.fortuneEnabled = fortuneEnabled;
    }

    @InstrumentForFailure
    public String sayHello() {
        String msg = getHelloMsg();;
        String quote;

        if (fortuneEnabled)
            quote = getFortune();
        else
            quote = "";

        if (quote == null || quote.equals(""))
            return msg;
        else
            return msg + ", " + quote;
    }

    abstract String getFortune();

    abstract String getHelloMsg();
}
