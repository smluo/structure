package com.recursion;

import java.util.Scanner;
import java.util.Stack;

public class RemainVal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(remainVal(sc.nextLine()));
    }

    public static String remainVal(String str) {
        String[] s = str.split(" ");
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            Stack<Integer> s2 = new Stack<>();
            int item = Integer.parseInt(s[i]);
            if (s1.size() == 0) {
                s1.push(item);
            } else {
                int sum = 0;
                boolean flag = false;
                int temp = 0;
                while (s1.size() > 0) {
                    temp = s1.pop();
                    sum += temp;
                    s2.push(temp);
                    if (sum == item) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    s1.push(2 * sum);
                } else {
                    while (s2.size() > 0) {
                        s1.push(s2.pop());
                    }
                    s1.push(item);
                }
            }
        }
        String res = "";
        while (s1.size() > 0) {
            if (s1.size() != 1) {
                res = res + s1.pop() + " ";
            } else {
                res += s1.pop();
            }
        }
        return res;
    }
}
