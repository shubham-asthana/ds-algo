package com.programming.dsalgo.strings;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords(" Hello World ") + "Shubham");
    }

    private static String reverseWords(String s) {
        if (s.length() <= 1)
            return s;

        System.out.println(s);
        String[] strArr = s.replaceAll("\\s+", " ").trim().split(" ");
        int i = 0, j = strArr.length - 1;
        while (i < j) {
            String temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", strArr);
    }
}
