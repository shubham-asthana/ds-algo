package com.programming.striversheet.basichashing;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfCharacters {

    public static void main(String[] args) {
        System.out.println(countFrequency1("abcdedfgdf", 'd'));
        System.out.println(countFrequency2("abcdedfgdf", 'f'));
    }

    private static int countFrequency1(String str, char ch) {
        int[] hash1 = new int[256];
        int[] hash2 = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash1[str.charAt(i)]++;
            hash2[str.charAt(i) - 'a']++;
        }
        return hash2[ch - 'a'];
    }

    // Storing and fetching in avg case = O(1) for hashmap, O(n) for worst case
    // because of collisions
    private static int countFrequency2(String str, char ch) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map.get(ch);
    }
}
