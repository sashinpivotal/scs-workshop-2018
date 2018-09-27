package io.pivotal.pal.demos.hystrix.failure;

import io.pivotal.pal.demos.hystrix.failure.command.Failure;
import io.pivotal.pal.demos.hystrix.failure.command.InjectLatency;
import io.pivotal.pal.demos.hystrix.failure.config.FailureProperty;

public class FailureFactory {
    private final FailureProperty failureProperties;

    public FailureFactory(FailureProperty failureProperties) {
        this.failureProperties = failureProperties;
    }

    public Failure getFailure() {
        return new InjectLatency(failureProperties);
    }
}
