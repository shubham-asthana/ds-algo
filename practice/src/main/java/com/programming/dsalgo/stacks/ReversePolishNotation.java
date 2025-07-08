package com.programming.dsalgo.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] input = new String[] { "4", "3", "-" };
        System.out.println(evalRPN(input));
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() > 1) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(operand2 + operand1);
                            break;
                        case "-":
                            stack.push(operand2 - operand1);
                            break;
                        case "*":
                            stack.push(operand2 * operand1);
                            break;
                        case "/":
                            stack.push(operand2 / operand1);
                            break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
