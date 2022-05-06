package com.linear.hash;

import java.util.Scanner;

/**
 * 哈希表
 *
 * @author smluo
 * @date 2022/05/06
 */
public class HashTab {
    /**
     * 链表+数组模拟实现哈希表
     */
    private EmpLinkedList[] empLinkedList;

    /**
     * 数组大小
     */
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedList = new EmpLinkedList[this.size];
        // 下面for循环遍历哈希表并初始化每个链表必不可少
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    public void add(Employee employee) {
        int index = hasFun(employee.no);
        EmpLinkedList empLinkedList = this.empLinkedList[index];
        empLinkedList.add(employee);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedList[i].list(i);
        }
    }

    /**
     * 根据编号查询哈希表中员工信息
     *
     * @param no
     */
    public void queryEmpByNo(int no) {
        // 获取no存放在数组中的下标
        int index = hasFun(no);
        Employee head = this.empLinkedList[index].head;
        if (head == null) {
            System.out.println("未查询到员工信息~~");
            return;
        }
        Employee tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.no == no) {
                flag = false;
                System.out.printf("no=%d name=%s\n", no, tmp.name);
                break;
            } else {
                tmp = tmp.next;
            }
        }
        if (flag) {
            System.out.println("未查询到员工信息~~");
        }
    }

    /**
     * 散列函数，用来判断待插入的员工放在数组的第几个位置
     *
     * @param no
     * @return
     */
    public int hasFun(int no) {
        return no % size;
    }
}

class EmpLinkedList {
    /**
     * 没有头节点
     */
    Employee head = null;

    /**
     * 新增
     *
     * @param employee
     */
    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        }
        Employee tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        // 循环结束走到这一步说明链表已经到达末尾
        tmp.next = employee;
    }

    /**
     * 遍历
     */
    public void list(int i) {
        if (head == null) {
            System.out.println("第" + (i + 1) + "个链表为空");
            return;
        }
        Employee tmp = head;
        System.out.print("第" + (i + 1) + "个链表");
        while (tmp != null) {
            System.out.printf("=> no=%d name=%s\t", tmp.no, tmp.name);
            tmp = tmp.next;
        }
        System.out.println();
    }
}

class Employee {
    /**
     * 编号
     */
    public int no;

    /**
     * 姓名
     */
    public String name;

    /**
     * next域，下一个员工信息
     */
    public Employee next;

    public Employee(int no, String name) {
        this.no = no;
        this.name = name;
    }
}

class HashTabTest {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        boolean loop = true;
        String key = "";
        while (loop) {
            System.out.println("a(add):新增员工");
            System.out.println("s(show):查看所有员工");
            System.out.println("q(query):根据编号查询员工");
            System.out.println("e(exist):退出程序");
            Scanner sc = new Scanner(System.in);
            key = sc.nextLine();
            switch (key) {
                case "a":
                    System.out.println("请输入员工编号");
                    int no = sc.nextInt();
                    System.out.println("请输入员工姓名");
                    String name = sc.next();
                    Employee employee = new Employee(no, name);
                    hashTab.add(employee);
                    break;
                case "s":
                    hashTab.list();
                    break;
                case "q":
                    System.out.println("请输入员工编号");
                    int empNo = sc.nextInt();
                    hashTab.queryEmpByNo(empNo);
                    break;
                case "e":
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出成功！");
    }
}