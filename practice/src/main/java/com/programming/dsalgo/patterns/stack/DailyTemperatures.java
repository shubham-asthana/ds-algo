package com.programming.dsalgo.patterns.stack;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temp = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] ans = dailyTemperatures(temp);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int popped = stack.pop();
                ans[popped] = i - popped;
            }
            stack.push(i);
        }
        return ans;
    }
}
