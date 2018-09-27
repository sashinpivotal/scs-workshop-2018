package io.pivotal.pal.demos.hystrix.greeting.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO Open query with Spring Cloud team for dynamic timeout props on rest template
// This and rest template builder config is workaround for Ribbon client timeout config being ignored

@ConfigurationProperties(prefix = "fortune-service.ribbon")
public class GreetingTimeoutProperties {
    private boolean clientTimeoutEnabled;
    private int ConnectTimeout;
    private int ReadTimeout;

    public boolean isClientTimeoutEnabled() {
        return clientTimeoutEnabled;
    }

    public void setClientTimeoutEnabled(boolean clientTimeoutEnabled) {
        this.clientTimeoutEnabled = clientTimeoutEnabled;
    }

    public int getConnectTimeout() {
        return ConnectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        ConnectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return ReadTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        ReadTimeout = readTimeout;
    }
}
