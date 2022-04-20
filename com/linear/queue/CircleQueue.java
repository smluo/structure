package com.linear.queue;

import java.util.Scanner;

/**
 * 环形队列
 *
 * @author smluo
 * @date 2022/04/20
 */
public class CircleQueue {
    /**
     * 数组的最大容量，会预留一个空间，所以队列的最大容量是maxSize-1
     */
    private int maxSize;

    /**
     * 队首指针，指向队首，初始值为0
     */
    private int front;

    /**
     * 队尾指针，指向队尾元素下一个预留空间的位置，初始值为0
     */
    private int rear;

    /**
     * 存储数据，同时包含一个预留空间，预留空间是不可以存储数据的
     */
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 向队列中添加元素
     *
     * @param item
     */
    public void addQueue(int item) {
        if (isFull()) {
            System.out.println("队列已经满了~~");
            return;
        }
        arr[rear] = item;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中移除元素
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 返回队首元素
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~");
        }
        return arr[front];
    }

    /**
     * 展示队列中所有元素
     */
    public void showQueue() {
        for (int i = front; i < front + value(); i++) {
            System.out.printf("arr[%d]:%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 队列中有效元素的个数
     *
     * @return
     */
    public int value() {
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        // 初始化队列
        CircleQueue circleQueue = new CircleQueue(4);
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
                    circleQueue.showQueue();
                    break;
                case 'e':
                    System.out.println("程序退出成功！");
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入要输入的元素：");
                    int item = scanner.nextInt();
                    circleQueue.addQueue(item);
                    break;
                case 'g':
                    try {
                        int value = circleQueue.getQueue();
                        System.out.print("移除元素：" + value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = circleQueue.headQueue();
                        System.out.println("队首元素为：" + head);
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
