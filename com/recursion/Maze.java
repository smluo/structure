package com.recursion;

/**
 * 迷宫问题
 */
public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][7];
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int i = 1; i <= 6; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[2][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d  ", maze[i][j]);
            }
            System.out.println();
        }
        setWay(maze, 1, 1);
        System.out.println("找到的线路：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d  ", maze[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 约定：当maze[i][j]为0表示没有走过，1表示墙，2表示通路可以走，3表示该点已经走过但是走不通
     * 走迷宫时候的策略：下->右->上->左，如果该点走不通再回溯
     *
     * @param maze 表示迷宫
     * @param i    出发位置的横坐标
     * @param j    出发位置的纵坐标
     * @return 如果找到通路返回true否则返回false
     */
    public static boolean setWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            if (maze[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略：下->右->上->左
                maze[i][j] = 2; // 假定该点是可以走通的
                if (setWay(maze, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(maze, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(maze, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(maze, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 说明该点走不通，是死路
                    maze[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }
}
