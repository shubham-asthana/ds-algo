package com.programming.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.programming.service.FruitService;

public class FruitServiceImpl implements FruitService {

    @Override
    public Map<String, Integer> countFruits(List<String> fruits) {
        Map<String, Integer> fruitFreqMap = new HashMap<>();
        for (String fruit : fruits) {
            if (fruitFreqMap.containsKey(fruit)) {
                int count = fruitFreqMap.get(fruit);
                fruitFreqMap.put(fruit, ++count);
            } else {
                fruitFreqMap.put(fruit, 1);
            }
        }
        return fruitFreqMap;
    }
}
