package io.pivotal.demos.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.event.EventListener;

@RemoteApplicationEventScan
public class CmdEventListener {
    private final Logger logger = LoggerFactory
            .getLogger(CmdEventListener.class);

    private final CmdCache cmdCache;

    public CmdEventListener(CmdCache cmdCache) {
        this.cmdCache = cmdCache;
    }

    @EventListener
    public void onBehaviorCmdChangeEvent(CmdChangeEvent event) {
        CmdChangeEvent.CmdDto cmdDto = event.getPropDto();
        putCmdToCache(cmdDto);
    }

    private void putCmdToCache(CmdChangeEvent.CmdDto cmdDto) {
        logger.debug("Putting a BehaviorCmd into cache");
        this.cmdCache.put(cmdDto.getName(),cmdDto.getValue());
    }
}
