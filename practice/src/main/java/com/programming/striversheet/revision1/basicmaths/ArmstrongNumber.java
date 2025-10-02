package com.programming.striversheet.revision1.basicmaths;

public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(1634));
        System.out.println(isArmstrongNumber(371));
    }

    private static boolean isArmstrongNumber(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int lastDigit = temp % 10;
            sum += lastDigit * lastDigit * lastDigit;
            temp /= 10;
        }
        return n == sum;
    }
}
