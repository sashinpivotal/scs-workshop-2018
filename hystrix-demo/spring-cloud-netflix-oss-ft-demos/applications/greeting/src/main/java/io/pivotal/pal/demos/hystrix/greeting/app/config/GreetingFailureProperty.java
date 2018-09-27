package io.pivotal.pal.demos.hystrix.greeting.app.config;

import io.pivotal.pal.demos.hystrix.failure.config.FailureProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("greeting.failure")
public class GreetingFailureProperty implements FailureProperty {
    private long latency;

    @Override
    public long getLatency() {
        return latency;
    }

    public void setLatency(long latency) {
        this.latency = latency;
    }

}
