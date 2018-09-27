package io.pivotal.demos.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudBusDemoApplication {

    @Autowired
    private ServiceMatcher busServiceMatcher;

    @Autowired
    private ApplicationEventPublisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusDemoApplication.class, args);
    }

    @Bean
    public CmdCache cmdCache() {
        return new CmdCache();
    }

    @Bean
    public CmdEventListener newCmdEventListener() {
        return new CmdEventListener(cmdCache());
    }

    @Bean
    public CmdEndpoint behaviorCmdEndpoint() {
        return new CmdEndpoint(busServiceMatcher,
                                    publisher,
                                    cmdCache());
    }
}
