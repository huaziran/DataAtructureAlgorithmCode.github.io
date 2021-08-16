package com.huaziran.tree;

public class ArrBinaryTreeDome {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        System.out.println("=====前序遍历"); //1245367
        arrBinaryTree.preOrder();
        System.out.println();
        System.out.println("=====中序遍历"); //4251637
        arrBinaryTree.infixOder();
    }
}

class ArrBinaryTree {
    private int[] arr;  //存储数距节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOder() {
        this.infixOrder(0);
    }

    /**
     * 完成顺序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //输出当前节点
        System.out.print(arr[index]);
        //左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder((index * 2 + 1));
        }
        //右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder((index * 2 + 2));
        }

    }

    /**
     * //数组二叉树的中序遍历
     *
     * @param index 返回值
     */
    public void infixOrder(int index) {
        //如果数组为空或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //左递归
        if ((index * 2 + 1) < arr.length) {
            infixOrder((index * 2 + 1));
        }
        //输出当前数组
        System.out.print(arr[index]);
        //右递归
        if ((index * 2 + 2) < arr.length) {
            infixOrder((index * 2 + 2));
        }
    }
    /*
    后续未结
     */
}
