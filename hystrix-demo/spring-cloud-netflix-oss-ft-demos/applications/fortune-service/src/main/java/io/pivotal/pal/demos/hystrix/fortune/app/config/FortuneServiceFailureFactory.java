package io.pivotal.pal.demos.hystrix.fortune.app.config;

import io.pivotal.pal.demos.hystrix.failure.FailureFactory;
import io.pivotal.pal.demos.hystrix.failure.instrument.InjectFailureAspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FortuneServiceFailureProperty.class)
public class FortuneServiceFailureFactory {
    private final FortuneServiceFailureProperty
            fortuneServiceFailureProperties;

    public FortuneServiceFailureFactory(FortuneServiceFailureProperty fortuneServiceFailureProperties) {
        this.fortuneServiceFailureProperties
                = fortuneServiceFailureProperties;
    }

    @Bean
    public FailureFactory failureFactory() {
        return new FailureFactory(fortuneServiceFailureProperties);
    }

    @Bean
    public InjectFailureAspect injectFailureAspect() {
        return new InjectFailureAspect(failureFactory());
    }
}
