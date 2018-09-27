package io.pivotal.pal.demos.hystrix.fortune.app.config;

import io.pivotal.pal.demos.hystrix.failure.config.FailureProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fortune-service.failure")
public class FortuneServiceFailureProperty implements
        FailureProperty {
    private long latency;

    @Override
    public long getLatency() {
        return latency;
    }

    public void setLatency(long latency) {
        this.latency = latency;
    }
}
