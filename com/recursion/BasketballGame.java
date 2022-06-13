package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasketballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(min(sc.nextLine()));
    }

    public static int min(String str) {
        String[] s = str.split(" ");
        List<Integer> list = new ArrayList<>();
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int avg = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            list.add(Integer.parseInt(s[i]));
            count += Integer.parseInt(s[i]);
        }
        avg = count / 2;
        while (list.size() > 0) {
            int min = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                int c = Math.abs(list.get(i) - avg);
                min = Math.min(min, c);
                if (min == c) {
                    index = i;
                }
            }
            int temp = list.get(index);
            list.remove(index);
            if (team1.size() > team2.size() || (team1.size() == team2.size() && count1 > count2)) {
                team2.add(temp);
                count2 += temp;
            } else {
                team1.add(temp);
                count1 += temp;
            }
        }
        return Math.abs(count1 - count2);
    }
}
