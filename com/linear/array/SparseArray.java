package com.linear.array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏数组
 *
 * @author smluo
 * @date 2022/04/19
 */
public class SparseArray {
    public static void main(String[] args) {
        // 定义一个11*11的二维数组表示棋盘，1表示：白子，2表示：黑子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        saveSparseArr(chessArr);
        readSparseArr();
    }

    /**
     * 获取输入的二维数组对应的稀疏数组，并持久化到磁盘
     *
     * @param arr
     */
    private static void saveSparseArr(int[][] arr) {
        int sum = 0;
        // 1.获取二维数组不为0的元素个数
        for (int[] item : arr) {
            for (int data : item) {
                sum = data == 0 ? sum : sum + 1;
            }
        }
        // 2.初始化稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;
        int index = 0;
        // 3.获取二维数组中不为0的元素的位置及值,并存储到对应的稀疏数组中
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = arr[i][j];
                }
            }
        }
        // 4.将稀疏数组持久化到磁盘中
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./sparse-array.txt"));
            for (int[] item : sparseArr) {
                for (int data : item) {
                    bufferedWriter.write(data + "\t");
                }
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取本地磁盘中稀疏数组，并转化成对应的二维数组
     */
    private static void readSparseArr() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./sparse-array-bak.txt"));
            String line = null;
            List<String> tmpList = new ArrayList<>();
            // 逐行读取文件
            while ((line = bufferedReader.readLine()) != null) {
                tmpList.add(line.trim());
            }
            // 1.初始化稀疏数组
            int sparseArr[][] = new int[tmpList.size()][3];
            // 2.给稀疏数组赋值
            for (int i = 0; i < tmpList.size(); i++) {
                String[] split = tmpList.get(i).split("\t");
                for (int j = 0; j < split.length; j++) {
                    sparseArr[i][j] = Integer.parseInt(split[j]);
                }
            }
            // 3.根据稀疏数组获取对应的二维数组
            int chessArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
            if (sparseArr.length <= 1) {
                return;
            }
            for (int i = 1; i < sparseArr.length; i++) {
                chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
            // 4.打印转化后的二维数组
            System.out.println("sparse-array-bak.txt转化后的二维数组~~~~~~~~~：");
            for (int[] item : chessArr) {
                for (int data : item) {
                    System.out.printf("%d\t", data);
                }
                System.out.println("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
