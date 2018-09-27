package io.pivotal.pal.demos.hystrix.fortune.app.config;

import io.pivotal.pal.demos.hystrix.fortune.services.FortuneService;
import io.pivotal.pal.demos.hystrix.fortune.services.PrimaryFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FortuneServiceAppFactory {
    @Bean
    public FortuneService fortuneService() {
        return new PrimaryFortuneService();
    }
}
