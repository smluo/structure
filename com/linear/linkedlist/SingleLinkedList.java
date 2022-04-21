package com.linear.linkedlist;

/**
 * 单链表
 *
 * @author smluo
 * @date 2022/04/21
 */
public class SingleLinkedList {

    /**
     * 头节点
     */
    HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加下一个节点，无序
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 思路：找到链表的最后一个节点，让最后一个节点的next等于要添加的节点即可
        HeroNode tmp = head;
        while (true) {
            // 找到最后一个节点，退出循环
            if (tmp.next == null) {
                break;
            }
            // 否则，tmp指向tmp.next
            tmp = tmp.next;
        }
        // 跳出循环，则证明tmp指向链表最后一个节点
        tmp.next = heroNode;
    }

    /**
     * 添加下一个节点，有序
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode tmp = head;
        // 判断要插入的节点编号是否已经存在
        Boolean flag = false;
        while (true) {
            // 到达最后一个节点
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no > heroNode.no) {
                break;
            } else if (tmp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.printf("链表中编号为：%d，已经存在\n", heroNode.no);
        } else {
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }

    }

    /**
     * 修改节点的属性
     *
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        HeroNode tmp = head.next;
        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.no == heroNode.no) {
                tmp.name = heroNode.name;
                tmp.nickName = heroNode.nickName;
                break;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 删除节点
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == no) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 遍历单链表,不包含头节点
     */
    public void list() {
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp.toString());
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟~~"));
        singleLinkedList.delete(1);
        singleLinkedList.list();
    }
}

/**
 * 水浒英雄实体类
 */
class HeroNode {
    /**
     * 编号
     */
    public int no;

    /**
     * 名称
     */
    public String name;

    /**
     * 别名
     */
    public String nickName;

    /**
     * 下一个英雄
     */
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name=" + name + ", nickName=" + nickName + '}';
    }
}
