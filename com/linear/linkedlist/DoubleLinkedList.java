package com.linear.linkedlist;

/**
 * 双向链表
 *
 * @author smluo
 * @date 2022/04/25
 */
public class DoubleLinkedList {
    private Node head = new Node(0, "");

    /**
     * 无序插入
     *
     * @param node
     */
    public void add(Node node) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.pre = tmp;
    }

    public void addByOrder(Node node) {
        Node tmp = head;
        // 判断要插入的节点编号是否已经存在
        Boolean flag = false;
        while (true) {
            // 到达最后一个节点
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no > node.no) {
                break;
            } else if (tmp.next.no == node.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.printf("链表中编号为：%d，已经存在\n", node.no);
        } else {
            node.next = tmp.next;
            node.pre = tmp;
            tmp.next = node;
            if (tmp.next != null) {
                tmp.next.pre = node;
            }
        }
    }

    /**
     * 修改
     *
     * @param node
     */
    public void update(Node node) {
        Node tmp = head.next;
        while (tmp != null) {
            if (tmp.no == node.no) {
                tmp.name = node.name;
                break;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 删除
     *
     * @param no
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        Node tmp = head.next;
        boolean flag = false;
        while (tmp != null) {
            if (tmp.no == no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.pre.next = tmp.next;
            // 如果要删除的节点是最后一个则不需要加上下面的逻辑
            if (tmp.next != null) {
                tmp.next.pre = tmp.pre;
            }
        } else {
            System.out.printf("链表中编号 %d不存在\n", no);
        }
    }

    /**
     * 展示所有节点
     */
    public void showNode() {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        Node tmp = head.next;
        while (tmp != null) {
            System.out.println(tmp.toString());
            tmp = tmp.next;
        }
    }
}

class Node {
    public int no;
    public String name;
    public Node next;
    public Node pre;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" + "no=" + no + ", name=" + name + '}';
    }
}

class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Node hero1 = new Node(1, "宋江");
        Node hero2 = new Node(2, "卢俊义");
        Node hero3 = new Node(3, "吴用");
        Node hero4 = new Node(4, "公孙胜");
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.update(new Node(4, "小公孙"));
        doubleLinkedList.delete(4);
        doubleLinkedList.showNode();
    }
}