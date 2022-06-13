package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortedStr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int len = s.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) { //提出2，转化A,J,Q,K
            switch (s[i]) {
                case "J":
                    list.add(11);
                    break;
                case "Q":
                    list.add(12);
                    break;
                case "K":
                    list.add(13);
                    break;
                case "A":
                    list.add(14);
                    break;
                case "2":
                    break;
                default:
                    list.add(Integer.valueOf(s[i]));
            }
        }

        Collections.sort(list); //从小到大排序方便取值2 9 J 10 2 3 4 K A 7 Q A 5 6

        List<List<Integer>> ress = new ArrayList<>();

        boolean isA = false; //是否遍历完整个数组

        while (!isA) {
            List<Integer> res = new ArrayList<>();
            res.add(list.get(0));   //放入第一个数字
            int count = 1;
            for (int i = 1; i < list.size(); i++) {
                int x = list.get(i);    //  本次数字
                if (x == list.get(i - 1) + 1) { //符合严格递增
                    count++;
                } else if (x == list.get(i - 1) && i != list.size() - 1) {
                    continue;   //本次数字等于前面一个数字且不是数组最后一位,则进入下次循环
                }
                if (x != list.get(i - 1) + 1 || i == list.size() - 1) {
                    if (count >= 5) {   //符合顺子
                        ress.add(res);
                    }
                    if (i == list.size() - 1) {   //整个数组遍历完全，直接退出
                        isA = true;
                        break;
                    }
                    for (int j = 0; j < res.size(); j++) {
                        for (int k = 0; k < list.size(); k++) {
                            if (res.get(j) == list.get(k)) {
                                list.remove(k); //剔除已经处理过的数字
                                break;
                            }
                        }
                    }
                    if (list.size() < 5) {  //集合剩余数字不满足成为顺子
                        isA = true;
                    }
                    break;  //顺子已经提取，跳出本次循环
                }
                res.add(x);
            }
        }

        if (ress.size() == 0) {
            System.out.println("No");
        } else {
            for (int i = 0; i < ress.size(); i++) {
                String stringRes = "";
                for (int j = 0; j < ress.get(i).size(); j++) {
                    switch (ress.get(i).get(j)) {    //将A\J\Q\K还原
                        case 11:
                            stringRes += "J";
                            break;
                        case 12:
                            stringRes += "Q";
                            break;
                        case 13:
                            stringRes += "K";
                            break;
                        case 14:
                            stringRes += "A";
                            break;
                        default:
                            stringRes += ress.get(i).get(j);
                    }
                    if (j < ress.get(i).size() - 1) {
                        stringRes += " ";
                    }
                }
                System.out.println(stringRes);
            }
        }
    }
}