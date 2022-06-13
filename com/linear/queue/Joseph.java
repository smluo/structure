package com.linear.queue;

public class Joseph {
    public static void main(String[] args) {
        CircleLinkedList c = new CircleLinkedList();
        c.add(5);
        System.out.println(c.joseph(1, 2, 10));

    }
}
class CircleLinkedList{
    Node head = null;
    public void add(int nums) {
        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.next = node;
                cur = head;
            } else {
                cur.next = node;
                node.next = head;
                cur = node;
            }
        }
    }

    /**
     *
     * @param startNo 第一个报数的节点编号
     * @param countNum 报数周期，比如从1喊到3紧接着又从1喊则countNum就为3
     * @param nums 开始时环内的节点数
     * @return
     */
    public int joseph(int startNo, int countNum, int nums) {
        if (startNo > nums || nums < 2) {
            System.out.println("参数不合法");
            return -1;
        }
        Node pre = head;
        // 循环pre指向环形链表最后
        while (pre.next != head) {
            pre = pre.next;
        }

        // 将head节点指向第一个报数的节点，pre指向这个节点的前一个节点
        for (int i = 0; i < startNo - 1; i++) {
            head = head.next;
            pre = pre.next;
        }

        // 开始报数,循环结束循环链表中只有一个节点
        while (pre != head) {
            // 下面for循环结束，head指向要出队的节点
            for (int i = 0; i < countNum - 1; i++) {
                head = head.next;
                pre = pre.next;
            }
            // 移除节点
            head = head.next;
            pre.next = head;
        }
        return pre.val;
    }
}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val =val;
    }
}
