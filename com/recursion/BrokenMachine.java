package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BrokenMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String relaStr = sc.nextLine();
        String brokenStr = sc.nextLine();
        System.out.println(searchBrokenMach(relaStr, brokenStr));
    }

    /**
     *
     * @param relaStr 各机器之间的依赖关系
     * @param brokenStr 故障的机器字符串
     * @return
     */
    public static String searchBrokenMach(String relaStr, String brokenStr) {
        String[] rela = relaStr.split(",");
        String[] broken = brokenStr.split(",");
        List<String> brokenList = Arrays.asList(broken);
        List<String> normal  = new ArrayList<>();
        for (int i = 0; i < rela.length; i++) {
            String left = rela[i].split("-")[0];
            String right = rela[i].split("-")[1];
            if (!isBroken(left, rela, brokenList) && !normal.contains(left)) {
                normal.add(left);
            }
            if (!isBroken(right, rela, brokenList) && !normal.contains(right)) {
                normal.add(right);
            }
        }
        if (normal.size() == 0) {
            return ",";
        }else {
            String res = "";
            for (int i = 0; i < normal.size(); i++) {
                res+=normal.get(i);
                if (i != normal.size() - 1) {
                    res+=",";
                }
            }
            return res;
        }
    }

    public static boolean isBroken(String node, String[] rela, List<String> brokenList) {
        // 如果这个机器已经在用户输入的坏机器字符串中直接返回，否则需要判断他依赖的机器是否是坏机器来判定自身的好坏
        if (brokenList.contains(node)) {
            return true;
        }
        // 如果node没有依赖任何机器，他自己只是被别的机器依赖，那么它就是正常机器
        for (int i = 0; i < rela.length; i++) {
            String left = rela[i].split("-")[0];
            String right = rela[i].split("-")[1];
            if (left.equals(node)) { // 如果它依赖了别的机器
                return isBroken(right, rela, brokenList);
            }
        }
        return false;
    }
}
