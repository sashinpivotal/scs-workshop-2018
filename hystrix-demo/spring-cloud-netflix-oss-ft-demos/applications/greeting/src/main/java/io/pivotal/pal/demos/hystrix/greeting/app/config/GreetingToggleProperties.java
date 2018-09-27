package io.pivotal.pal.demos.hystrix.greeting.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("greeting.toggles")
public class GreetingToggleProperties {
    private boolean fortuneEnabled;

    public boolean isFortuneEnabled() {
        return fortuneEnabled;
    }

    public void setFortuneEnabled(boolean fortuneEnabled) {
        this.fortuneEnabled = fortuneEnabled;
    }
}
