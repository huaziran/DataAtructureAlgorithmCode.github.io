package com.huaziran.binarysorttree;
@SuppressWarnings({"all"})
public class BnarySortTreeDome {
    public static void main(String[] args) {
        int array[] = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i<array.length; i++) {
            binarySortTree.add(new Node(array[i]));
        }

        //中序遍历输出
        System.out.println("中序遍历输出");
        binarySortTree.infixOder();
    }
}
class BinarySortTree{
    private Node root; //
    //添加节点
    public void add(Node node){
        if (root == null){ //如果root为空，就让传来的node为root为头节点
            root =node;
        }else{
            root.add(node);
        }
    }
    //中序遍历
    public void infixOder() {
        if (root != null){
            root.infixOder();
        }else {
            System.out.println("二叉树为空");
        }

    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //添加节点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入的值，添加的值小于当前节点的值
        if (node.value < this.value) {
            //如果当前节点的左节点为空
            if (this.left == null) {
                this.left = node; //挂上添加的节点
            } else {
                //递归向左子树添加
                this.left.add(node);
            }
        }else{        //判断传入的值，添加的值大于当前节点的值
            if (this.right == null) {
                this.right = node; //
            }else{
                this.right.add(node);
            }
        }
    }
    public void infixOder(){
        if(this.left != null){
            this.left.infixOder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}