package com.programming.striversheet.revision1.basicmaths;

public class CheckPrime {

    public static void main(String[] args) {
        System.out.println(checkPrime1(15));
        System.out.println(checkPrime1(11));
        System.out.println(checkPrime2(15));
        System.out.println(checkPrime2(11));
    }

    private static boolean checkPrime1(int num) {
        if (num == 0 || num == 1)
            return false;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }
        return count == 2;
    }

    private static boolean checkPrime2(int num) {
        if (num == 0 || num == 1)
            return false;
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (i != num / i)
                    count++;
            }
        }
        return count == 2;
    }
}
