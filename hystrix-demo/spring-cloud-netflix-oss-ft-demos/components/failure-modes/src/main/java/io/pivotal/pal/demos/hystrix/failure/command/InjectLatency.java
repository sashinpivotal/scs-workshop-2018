package io.pivotal.pal.demos.hystrix.failure.command;

import io.pivotal.pal.demos.hystrix.failure.config.FailureProperty;

public class InjectLatency implements Failure {
    private final FailureProperty failureProperties;

    public InjectLatency(FailureProperty failureProperties) {
        this.failureProperties = failureProperties;
    }

    private long getLatency() {
        return this.failureProperties.getLatency();
    }

    public void execute() {
        try {
            Thread.sleep(getLatency());
        } catch (InterruptedException e) {
            // No Exception Handling Required
        }
    }
}
