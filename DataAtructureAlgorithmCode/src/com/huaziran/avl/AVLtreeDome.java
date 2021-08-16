package com.huaziran.avl;

@SuppressWarnings({"all"})
public class AVLtreeDome {
    public static void main(String[] args) {

//        int[] array = {4, 3, 6, 5, 7, 8};
//        int[] array = {10, 12, 8, 9, 7, 6};
        int[] array = {10, 11, 7, 6, 8, 9};

        AVLBinaryTree avlBinaryTree = new AVLBinaryTree();
        for (int i = 0; i < array.length; i++) {
            avlBinaryTree.add(new Node(array[i]));
        }

        System.out.println("中序遍历");
        avlBinaryTree.infixOder();

        System.out.println("没有旋转");
        System.out.println("树的高度：" + avlBinaryTree.getRoot().height());
        System.out.println("左子树的高度：" + avlBinaryTree.getRoot().leftHeights());
        System.out.println("右子树的高度：" + avlBinaryTree.getRoot().rightHeights());
        System.out.println("当前的根节点：" + avlBinaryTree.getRoot());
        System.out.println("当前的根节点的左节点：" + avlBinaryTree.getRoot().left);
        System.out.println("当前的根节点的右节点：" + avlBinaryTree.getRoot().right);
    }
}

//创建树
class AVLBinaryTree {
    private Node root; //
    //添加节点

    public AVLBinaryTree() {
    }

    public AVLBinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        if (root == null) { //如果root为空，就让传来的node为root为头节点
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOder() {
        if (root != null) {
            root.infixOder();
        } else {
            System.out.println("二叉树为空");
        }

    }
}

@SuppressWarnings({"all"})
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeights() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右节点的高度
    public int rightHeights() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前节点的高度，以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    //左旋转
    private void leftRotate() {
        //创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成带你过去节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点值
        value = right.value;
        //把当前节点右子树设置成当前节点右子树的右子树
        right = right.right;
        //把当前节点的左子树设置成新的节点
        left = newNode;
    }

    //右旋转
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
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
        } else {        //判断传入的值，添加的值大于当前节点的值
            if (this.right == null) {
                this.right = node; //
            } else {
                this.right.add(node);
            }
        }
        //当添加完一个节点后，如果右子树的高度-左子树的高度>1,进行左旋转
        if (rightHeights() - leftHeights() > 1) {
            //如果他的右子树的左子树的高度大于右子树的高度
            if (right != null && right.leftHeights() > right.rightHeights()) {
                //先对右子节点进行右旋转
                right.rightRotate();
                leftRotate();
            } else {//直接坐旋转
                leftRotate();
            }
            return;//必须要
        }
        if (leftHeights() - rightHeights() > 1) {
            //如果他的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeights() > left.leftHeights()) {
                //先坐旋转在右旋转
                left.leftRotate();
                rightRotate();
            } else {
                //直接右旋转
                rightRotate();
            }
        }
    }

    public void infixOder() {
        if (this.left != null) {
            this.left.infixOder();
        }
        System.out.println(this);
        if (this.right != null) {
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