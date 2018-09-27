package io.pivotal.pal.demos.hystrix.greeting.app.config;

import io.pivotal.pal.demos.hystrix.greeting.app.services.ProtectedHelloService;
import io.pivotal.pal.demos.hystrix.greeting.clients.FortuneServiceClient;
import io.pivotal.pal.demos.hystrix.greeting.services.BackupHelloService;
import io.pivotal.pal.demos.hystrix.greeting.services.FalloutHelloService;
import io.pivotal.pal.demos.hystrix.greeting.services.HelloService;
import io.pivotal.pal.demos.hystrix.greeting.services.PrimaryHelloService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({GreetingToggleProperties.class,
        GreetingTimeoutProperties.class})
public class GreetingAppBuilder {
    private final GreetingToggleProperties greetingToggleProperties;
    private final GreetingTimeoutProperties greetingTimeoutProperties;

    public GreetingAppBuilder(GreetingToggleProperties
                                      greetingToggleProperties,
                              GreetingTimeoutProperties
                                      greetingTimeoutProperties) {
        this.greetingToggleProperties = greetingToggleProperties;
        this.greetingTimeoutProperties = greetingTimeoutProperties;
    }

    // TODO Implement Feign Example for refreshable timeouts, this solution is not
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        if (greetingTimeoutProperties.isClientTimeoutEnabled()) {
            return restTemplateBuilder
                    .setConnectTimeout(greetingTimeoutProperties
                            .getConnectTimeout())
                    .setReadTimeout(greetingTimeoutProperties
                            .getReadTimeout()).build();

        } else {
            return new RestTemplate();
        }
    }

    @RefreshScope
    @Bean
    public FortuneServiceClient fortuneServiceClient() {
        return new FortuneServiceClient(restTemplate());
    }

    @RefreshScope
    @Qualifier("primaryHelloService")
    @Bean
    public HelloService primaryHelloService() {
        return new PrimaryHelloService(fortuneServiceClient(),
                greetingToggleProperties.isFortuneEnabled());
    }

    @RefreshScope
    @Qualifier("backupHelloService")
    @Bean
    public HelloService backupHelloService() {
        return new BackupHelloService(
                greetingToggleProperties.isFortuneEnabled());
    }

    @RefreshScope
    @Qualifier("falloutHelloService")
    public HelloService falloutHelloService() {
        return new FalloutHelloService(
                greetingToggleProperties.isFortuneEnabled());
    }

    @RefreshScope
    @Primary
    @Bean
    public HelloService helloService() {
        return new ProtectedHelloService(primaryHelloService(),
                backupHelloService(),
                falloutHelloService());
    }
}
