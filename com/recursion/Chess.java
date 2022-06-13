package com.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int col = Integer.parseInt(s[0]);
        int row = Integer.parseInt(s[1]);
        int[][] map = new int[row][col];
        String[] s1 = sc.nextLine().split(" ");
        int stepNum = 0;
        for (int i = 0; i < s1.length; i++) {
            stepNum++;
            // i为偶数时表示红方，i为奇数表示蓝方
            int column = Integer.parseInt(s1[i]);
            // 1.选手落子未在指定区间或待落子的列已经满了
            if (column <= 0 || column > col || map[0][column - 1] != 0) {
                System.out.println(stepNum + ",error");
                return;
            }
            // 2.正常落子，每落一子查询该子横向、纵向及斜向自己的连续棋子最大数，红方落子记：1，蓝方记：2
            int j = 0;
            while (j < row && map[j][column - 1] == 0) {
                j++;
            }
            map[j - 1][column - 1] = i % 2 == 0 ? 1 : 2;
            // 查询最大连接数
            int max = maxJoin(map, j - 1, column - 1, map[j - 1][column - 1]);
            if (max == 4) {
                System.out.println(stepNum + "," + (i % 2 == 0 ? "red" : "blue"));
                break;
            }

        }
        for (int[] item : map) {
            System.out.println(Arrays.toString(item));
        }
    }

    /**
     * @param map 棋盘
     * @param i   横坐标
     * @param j   纵坐标
     * @param val map[i][j]的值
     * @return
     */
    public static int maxJoin(int[][] map, int i, int j, int val) {
        int max = 0;
        int pre = 0;
        int next = 0;
        int x = i;
        int y = j;
        // 1.先横着找
        // 先向左循环查找
        while (y > 0) {
            if (map[x][y - 1] == val) {
                pre++;
                y--;
            } else {
                break;
            }
        }
        y = j;
        // 向右循环查找
        while (y < map[0].length - 1) {
            if (map[x][y + 1] == val) {
                next++;
                y++;
            } else {
                break;
            }
        }
        y = j;
        // 2.竖着找
        // 3.斜着找
        // 取1.2.3中最大值
        max = Math.max(max, pre + next + 1);
        return max;
    }
}
