package com.huaziran.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Huffmantree {

    public static void main(String[] args) {
        int array[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(array);
        preOrder(root);

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }

    //创建哈夫曼树的法方
    public static Node createHuffmanTree(int[] arr) {
        //将数组编程Node
        List<Node> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }

        //循环节点
        while (nodes.size() > 1) { //最后只剩下最后一个头节点
            //排序
            Collections.sort(nodes);
            System.out.println("node:" + nodes);

            //取出根节点权值最小的两颗二叉树
            //取出权值第二小的的节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构建新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //从数组中删除已经用过的二叉树节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的parent加入数组中
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//为了让Node对象持续排序Collections集合排序
//让Node实现Comparable
//创建节点
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}