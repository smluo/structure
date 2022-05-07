package com.nonlinear.tree;

/**
 * 二叉树
 *
 * @author smluo
 * @since 2022/05/08
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
            return;
        }
        root.preOrder();
    }

    public void midOrder() {
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
            return;
        }
        root.midOrder();
    }

    public void sufOrder() {
        if (root == null) {
            System.out.println("二叉树为空，无法遍历");
            return;
        }
        root.sufOrder();
    }
}

/**
 * 水浒英雄作为树的节点
 */
class HeroNode {
    /**
     * 编号
     */
    private int no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 单个节点的左子节点
     */
    private HeroNode left;

    /**
     * 单个节点的右子节点
     */
    private HeroNode right;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.printf("no=%d name=%s\n", this.no, this.name);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.printf("no=%d name=%s\n", this.no, this.name);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void sufOrder() {
        if (this.left != null) {
            this.left.sufOrder();
        }
        if (this.right != null) {
            this.right.sufOrder();
        }
        System.out.printf("no=%d name=%s\n", this.no, this.name);
    }
}

class BinaryTreeTest {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode hero2 = new HeroNode(2, "卢俊义");
        HeroNode hero3 = new HeroNode(3, "吴用");
        HeroNode hero4 = new HeroNode(4, "公孙胜");
        HeroNode hero5 = new HeroNode(5, "关胜");
        HeroNode hero6 = new HeroNode(6, "林冲");
        HeroNode hero7 = new HeroNode(7, "秦明");
        HeroNode hero8 = new HeroNode(8, "呼延灼");
        HeroNode hero9 = new HeroNode(9, "花荣");
        HeroNode hero10 = new HeroNode(10, "柴进");
        HeroNode hero11 = new HeroNode(11, "李应");
        root.setLeft(hero2);
        root.setRight(hero3);
        hero2.setLeft(hero4);
        hero2.setRight(hero5);
        hero3.setLeft(hero6);
        hero3.setRight(hero7);
        hero4.setLeft(hero8);
        hero4.setRight(hero9);
        hero5.setRight(hero10);
        hero6.setRight(hero11);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.preOrder();
        binaryTree.midOrder();
        binaryTree.sufOrder();
    }
}
