package io.pivotal.pal.demos.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryServerApplication.class,
                args);
    }
}
