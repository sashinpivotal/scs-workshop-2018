package io.pivotal.pal.demos.hystrix.greeting.app.config;

import io.pivotal.pal.demos.hystrix.failure.FailureFactory;
import io.pivotal.pal.demos.hystrix.failure.instrument.InjectFailureAspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GreetingFailureProperty.class)
public class GreetingFailureFactory {
    private final GreetingFailureProperty greetingFailureProperties;

    public GreetingFailureFactory(GreetingFailureProperty
                                          greetingFailureProperties) {
        this.greetingFailureProperties = greetingFailureProperties;
    }

    @Bean
    public FailureFactory failureFactory() {
        return new FailureFactory(greetingFailureProperties);
    }

    @Bean
    public InjectFailureAspect injectFailureAspect() {
        return new InjectFailureAspect(failureFactory());
    }
}
