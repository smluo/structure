package com.linear.linkedlist;

/**
 * 环形的单向链表
 *
 * @author smluo
 * @date 2022/04/25
 */
public class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    /**
     * 创建一个size大小的环形链表
     *
     * @param size
     */
    public void add(int size) {
       if (size < 1) {
           return;
       }
       Boy curBoy = null;
        for (int i = 1; i <= size; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空~~");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) { // 说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}
class Boy {
    private int no;

    private String name;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" + "no=" + no + '}';
    }
}
class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleLinkedList = new CircleSingleLinkedList();
        circleLinkedList.add(5);
        circleLinkedList.showBoy();
    }
}