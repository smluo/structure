package com.linear.queue;

import java.util.Scanner;

/**
 * 普通队列，通过数组加指针的方式实现,数组空间不能循环利用需要优化
 *
 * @author smluo
 * @date 2022/04/20
 */
public class ArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;

    /**
     * 队首指针指向队首前一位，初始值为-1
     */
    private int front;

    /**
     * 队尾指针指向队尾，初始值为-1
     */
    private int rear;

    /**
     * 该数组用于存储数据，模拟队列
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    /**
     * 判断队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 向队列添加元素
     *
     * @param item
     */
    public void addQueue(int item) {
        if (isFull()) {
            System.out.println("队列已经满了~~");
            return;
        }
        rear++;
        arr[rear] = item;
    }

    /**
     * 从队列移除元素（遵循先进先出原则）
     */
    public void getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了~~");
        }
        front++;
    }

    /**
     * 展示队列所有元素
     */
    public void showQueue() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]:%d\n", i, arr[i]);
        }
    }

    /**
     * 展示队首元素
     */
    public void headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了~~");
        }
        System.out.printf("队首元素为：%d\n", arr[front + 1]);
    }

    public static void main(String[] args) {
        // 初始化队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列元素");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加元素");
            System.out.println("g(get):移除元素");
            System.out.println("h(head):获取队首元素");
            Scanner scanner = new Scanner(System.in);
            char c = scanner.nextLine().charAt(0);
            switch (c) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    System.out.println("程序退出成功！");
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入要输入的元素：");
                    int item = scanner.nextInt();
                    arrayQueue.addQueue(item);
                    break;
                case 'g':
                    try {
                        arrayQueue.getQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        arrayQueue.headQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
