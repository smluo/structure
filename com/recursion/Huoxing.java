package com.recursion;

import java.util.Scanner;
import java.util.Stack;

public class Huoxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(cal(sc.nextLine()));
    }

    public static int cal(String str) {
        Stack<Character> operStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int l = 0;
        String temp = "";
        while (l < str.length()) {
            if (str.charAt(l) != '#' && str.charAt(l) != '$') {
                temp += str.charAt(l);
            } else {
                // 先将操作符之前的数字入数字栈
                numStack.push(Integer.parseInt(temp));
                temp = "";
                // 处理操作符
                // 先判断操作符栈是否为空
                if (operStack.size() == 0) {
                    operStack.push(str.charAt(l));
                } else {
                    // 如果扫描到的操作符优先级比操作符栈顶的操作符优先级高则直接入操作符栈
                    if (isPriority(str.charAt(l), operStack.peek())) {
                        operStack.push(str.charAt(l));
                    } else {// 否则从数字栈弹出两个数字，从操作符栈弹出一个运算符进行计算
                        int b = numStack.pop();
                        int a = numStack.pop();
                        char ch = operStack.pop();
                        int res = calculate(a, b, ch);
                        if (operStack.size() > 0) {
                            res = calculate(numStack.pop(), res, operStack.pop());
                        }
                        numStack.push(res);
                        operStack.push(str.charAt(l));
                    }
                }
            }
            l++;
            if (l == str.length()) {
                numStack.push(calculate(numStack.pop(), Integer.parseInt(temp), operStack.pop()));
            }
        }
        return numStack.pop();
    }

    public static boolean isPriority(char ch1, char ch2) {
        return ch1 > ch2;
    }

    public static int calculate(int a, int b, char ch) {
        return ch == '#' ? (2 * a + 3 * b + 4) : (3 * a + b + 2);
    }
}
