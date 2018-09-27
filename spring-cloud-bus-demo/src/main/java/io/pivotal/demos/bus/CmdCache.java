package io.pivotal.demos.bus;

import java.util.HashMap;
import java.util.Map;

public class CmdCache {
    private final Map<String,String> cmdCache;

    public CmdCache() {
        this.cmdCache = new HashMap<>();
    }

    public void put(String cmdKey, String cmd) {
        this.cmdCache.put(cmdKey,cmd);
    }

    public String get(String cmdKey) {
        return this.cmdCache.get(cmdKey);
    }

    public Map<String,String> getAll() {
        return this.cmdCache;
    }
}
