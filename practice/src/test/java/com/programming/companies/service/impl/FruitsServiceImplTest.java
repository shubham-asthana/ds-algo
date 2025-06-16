package com.programming.companies.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.programming.companies.service.FruitService;

public class FruitsServiceImplTest {

    FruitService fruitService = new FruitServiceImpl();

    @Test
    public void testFruitCount() {
        List<String> fruits = Arrays.asList("apple", "banana", "guava", "apple");
        int count = fruitService.countFruits(fruits).get("apple");
        assertEquals(2, count);
    }

    @Test
    public void testFruitCount_Error() {
        List<String> fruits = Arrays.asList("apple", "banana", "guava", "apple");
        assertNull(fruitService.countFruits(fruits).get("mango"));
    }
}
