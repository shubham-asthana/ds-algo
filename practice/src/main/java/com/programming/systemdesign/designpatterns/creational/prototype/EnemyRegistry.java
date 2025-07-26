package com.programming.systemdesign.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {

    private Map<String, Enemy> prototypes = new HashMap<>();

    public void register(String key, Enemy protoType) {
        prototypes.put(key, protoType);
    }

    public Enemy get(String key) {
        Enemy protoType = prototypes.get(key);
        if (null != protoType) {
            return protoType.clone();
        }
        throw new IllegalArgumentException("No prototype registered for: " + key);
    }
}
