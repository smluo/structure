package com.linear.stack;

/**
 * 数组模拟栈的实现
 *
 * @author smluo
 * @date 2022/04/27
 */
public class ArrayStack {
    /**
     * 栈的大小
     */
    public int maxSize;

    /**
     * 数组模拟栈，数据就存放在该数组
     */
    public int[] stack;

    /**
     * 栈顶指针，初始值为-1
     */
    public int top = -1;

    public ArrayStack(int maxSize) {
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param item
     */
    public void push(int item) {
        if (isFull()) {
            System.out.println("栈满~~");
            return;
        }
        top++;
        stack[top] = item;
    }

    /**
     * 出栈，返回栈顶元素
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~");
        }
        int item = stack[top];
        top--;
        return item;
    }

    /**
     * 遍历栈
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空~~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}

class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.list();
        for (int i = 0; i < 6; i++) {
            try {
                System.out.println(arrayStack.pop());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}