package com.programming.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

public class HashSet {

    List<Integer> hashSet;

    public HashSet() {
        hashSet = new ArrayList<>();
    }

    public void add(int key) {
        if (!hashSet.contains(key)) {
            hashSet.add(key);
        }
    }

    public void remove(int key) {
        if (hashSet.contains(key)) {
            hashSet.remove((Object) key);
        }
    }

    public boolean contains(int key) {
        return hashSet.contains(key);
    }
}
