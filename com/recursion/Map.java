package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题
 */
public class Map {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int col = Integer.parseInt(str.split(" ")[0]);
        int row = Integer.parseInt(str.split(" ")[1]);
        int[][] map = new int[row][col];
        // 小华和小为的坐标
        List<int[][]> hwLlist = new ArrayList<>();
        // 聚餐地的坐标
        List<int[][]> resList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            String[] in = sc.nextLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                if (map[i][j] == 2) {
                    int[][] hw = new int[1][2];
                    hw[0][0] = i;
                    hw[0][1] = j;
                    hwLlist.add(hw);
                } else if (map[i][j] == 3) {
                    int[][] res = new int[1][2];
                    res[0][0] = i;
                    res[0][1] = j;
                    resList.add(res);
                }
            }
        }

        int res = 0;
        for (int m = 0; m < resList.size(); m++) {
            int[][] huaArr = copy(map);
            int[][] weiArr = copy(map);
            System.out.println("初始化地图，目的地：(" + resList.get(m)[0][0] + ", " + resList.get(m)[0][1] + ")");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.printf("%d  ", huaArr[i][j]);
                }
                System.out.println();
            }
            boolean hua = isArrive(hwLlist.get(0)[0][0], hwLlist.get(0)[0][1], resList.get(m)[0][0], resList.get(m)[0][1], huaArr);
            boolean wei = isArrive(hwLlist.get(1)[0][0], hwLlist.get(1)[0][1], resList.get(m)[0][0], resList.get(m)[0][1], weiArr);
            if (hua && wei) {
                res++;
            }
            System.out.println("小华开始位置：(" + hwLlist.get(0)[0][0] + ", " + hwLlist.get(0)[0][1] + "),行走的路线：" + hua);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.printf("%d  ", huaArr[i][j]);
                }
                System.out.println();
            }
            System.out.println("小为开始位置：(" + hwLlist.get(1)[0][0] + ", " + hwLlist.get(1)[0][1] + "),行走的路线：" + wei);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.printf("%d  ", weiArr[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println("共有：" + res + "个可达的目的地");

    }

    /**
     * 拷贝一个二维数组
     *
     * @param arr
     * @return
     */
    public static int[][] copy(int[][] arr) {
        int[][] temp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    /**
     * 判断是否可以从（startX,startY）到达（endX, endY)按照下->右->上->左的策略执行
     * map[i][j]为0时候表示未走过，1表示障碍物，2表示小华和小为，3为被选中的聚餐地点
     * 6:表示可以走通 7：表示是死路
     *
     * @param startX 开始位置的横坐标
     * @param startY 开始位置的纵坐标
     * @param endX   结束位置的横坐标
     * @param endY   结束位置的纵坐标
     * @param map
     * @return
     */
    public static boolean isArrive(int startX, int startY, int endX, int endY, int[][] map) {
        if (map[endX][endY] == 6) {
            return true;
        }

        if (startX < 0 || startY < 0 || startX >= map.length || startY >= map[0].length) {
            return false;
        }

        if (map[startX][startY] == 3 || map[startX][startY] == 2 || map[startX][startY] == 0) {
            map[startX][startY] = 6;
            if (isArrive(startX + 1, startY, endX, endY, map)) { // 向下走
                return true;
            } else if (isArrive(startX, startY + 1, endX, endY, map)) { // 向右走
                return true;
            } else if (isArrive(startX - 1, startY, endX, endY, map)) { // 向上走
                return true;
            } else if (isArrive(startX, startY - 1, endX, endY, map)) { // 向左走
                return true;
            } else {
                map[startX][startY] = 7;
                return false;
            }
        } else {
            return false;
        }
    }
}
