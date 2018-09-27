package io.pivotal.demos.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Map;

@Endpoint(id = "new-command")
public class CmdEndpoint {
    private final Logger logger = LoggerFactory
            .getLogger(CmdEndpoint.class);
    private final ServiceMatcher busServiceMatcher;
    private final ApplicationEventPublisher publisher;
    private final CmdCache cmdCache;

    public CmdEndpoint(ServiceMatcher busServiceMatcher,
                       ApplicationEventPublisher publisher,
                       CmdCache cmdCache) {
        this.busServiceMatcher = busServiceMatcher;
        this.publisher = publisher;
        this.cmdCache = cmdCache;
    }

    @ReadOperation
    public Map<String, String> getCache() {
        logger.debug("Getting BehaviorCmd cache");

        return this.cmdCache.getAll();
    }

    @WriteOperation
    public void publishCmd(String name,
                           String value
    ) {
        CmdChangeEvent.CmdDto cmdDto =
                new CmdChangeEvent.CmdDto(name,value);

        this.publisher.publishEvent(new CmdChangeEvent(
                this, busServiceMatcher.getServiceId(),
                cmdDto));
    }
}
