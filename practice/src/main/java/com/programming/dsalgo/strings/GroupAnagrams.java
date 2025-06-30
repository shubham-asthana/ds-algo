package com.programming.dsalgo.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        // O(m * nlogn)
        // for (String str : strs) {
        // char[] chars = str.toCharArray();
        // Arrays.sort(chars);
        // String sortedString = new String(chars);
        // anagramGroups.putIfAbsent(sortedString, new ArrayList<>());
        // anagramGroups.get(sortedString).add(str);
        // }

        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] count = new int[26];
            for (char c : chars) {
                count[c - 'a']++;
            }
            String sortedString = Arrays.toString(count);
            System.out.println(count);
            anagramGroups.putIfAbsent(sortedString, new ArrayList<>());
            anagramGroups.get(sortedString).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
