package com.labwork.jspjava.jdbc;

import java.util.Map;
import java.util.Random;

public record SessionService(Random random, Map<Integer, String> map) {

    public String createToken(String value) {
        int code = random.nextInt(100000, 999999);
        map.put(code, value);
        return String.valueOf(code);
    }

    public String getValue(String key) {
        int code = Integer.parseInt(key);
        return map.getOrDefault(code, "Not found");
    }
}
