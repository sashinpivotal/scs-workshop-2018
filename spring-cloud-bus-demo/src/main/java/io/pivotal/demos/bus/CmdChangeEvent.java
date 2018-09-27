package io.pivotal.demos.bus;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class CmdChangeEvent extends RemoteApplicationEvent {
    private CmdDto propDto;

    CmdChangeEvent(Object source,
                   String originService,
                   CmdDto propsDto) {
        super(source, originService);
        this.propDto = propsDto;
    }

    CmdDto getPropDto() {
        return propDto;
    }

    public static class CmdDto {
        private String name;
        private String value;

        CmdDto(
                String name,
                String value
        ) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
