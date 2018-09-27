package io.pivotal.pal.demos.hystrix.greeting.clients;

import org.springframework.web.client.RestTemplate;

public class FortuneServiceClient {
    private final RestTemplate restTemplate;

    public FortuneServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFortune() {
        return restTemplate.getForObject("http://fortune-service",
                String.class);
    }
}
