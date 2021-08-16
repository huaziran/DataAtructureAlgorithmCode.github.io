package com.huaziran.tree.ThreadedbinaryTree;

@SuppressWarnings({"all"})
public class ThreadedBinaryTreeDome {

    public static void main(String[] args) {

        //测试中序线索二叉树
        HeroNode root = new HeroNode(1, "tom");
        HeroNode heroNode2 = new HeroNode(3, "jack");
        HeroNode heroNode3 = new HeroNode(6, "smith");
        HeroNode heroNode4 = new HeroNode(8, "mary");
        HeroNode heroNode5 = new HeroNode(10, "king");
        HeroNode heroNode6 = new HeroNode(14, "dim");
        //二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        TheadedBinaryTree theadedBinaryTree = new TheadedBinaryTree();
        theadedBinaryTree.setRoot(root);
//        theadedBinaryTree.preOrder();
        theadedBinaryTree.threadedNodes();

        //测试
        HeroNode leftNode = heroNode5.getLeft();
        System.out.println("10号的前驱节点" + leftNode);
        System.out.println("使用线索化遍历二叉树：");
        theadedBinaryTree.threadedList();
    }
}

//创建二叉树
@SuppressWarnings({"all"})
class TheadedBinaryTree {
    private HeroNode root;
    //为了实现线索化，需要创建要指向当前节点的前驱节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载threadedbinary方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树
    public void threadedList() {
//        定义一个存储当前遍历的节点，从root开始
        HeroNode temp = root;
        while (temp != null) {
            //循环的找到lefttype ==1的节点，第一个就是8节点
            //后面
            while (temp.getLeftType() == 0) {
                temp = temp.getLeft();
            }
            System.out.println(temp);
//            当前节点的右指针指向后继节点，就一直输出
            while (temp.getRightType() == 1) {
                temp = temp.getRight();
                System.out.println(temp);
            }
//            替换这个遍历的节点
            temp = temp.getRight();
        }
    }

    /**
     * //编写对二叉树线索化
     *
     * @param node 就是当前进行中序线索化的节点
     */
    public void threadedNodes(HeroNode node) {
        //如果node == null，不能线索化
        if (node == null) {
            return;
        }
        //（-）线索化左子树
        threadedNodes(node.getLeft());
        //（二）线索化当前节点
        //先处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //如果没有左节点，那我们就当前节点的左节点为空节点
            node.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }
//        处理后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //（三）线索化右节点
        threadedNodes(node.getRight());
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            //只有root一个节点那就判断root是不是要删除的节点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("二叉树为空");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.PreOder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOder() {
        if (this.root != null) {
            this.root.infixOder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //前序查找
    public HeroNode preOrderSeach(int no) {
        if (root != null) {
            return root.preOrderSeach(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOderSeach(int no) {
        if (root != null) {
            return root.infixOderSeach(no);
        } else {
            return null;
        }
    }


    //后序查找
    public HeroNode postOderSeach(int no) {
        //后续查找
        if (root != null) {
            return root.postOderSeach(no);
        } else {
            return null;
        }
    }

}

@SuppressWarnings({"all"})
class HeroNode {
    private int no; //
    private String name; //
    private HeroNode left; //默认为空
    private HeroNode right;//默认为空

    //规定：如果leftType==0，表示指向左子树，如果等于1，指向前驱节点
    //      如果rightType==0，表示指向左子树，如果等于1，指向前驱节点
    private int leftType; //
    private int rightType; //

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode(int no, String name, int leftType, int rightType) {
        this.no = no;
        this.name = name;
        this.leftType = leftType;
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点

    public void delNode(int no) {
        //2.如果当前结点的左子结点不为空,并且左子结点就是要删除结点,
        // 就将this.1eft = nu1l; 并且就返回(结束递归删除)
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点就是要删除结点;
        //,就将this.right=null;并且就返回(结束递归删除)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
//        左子树递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //右递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }


    // 节点的方法
    //前序遍历
    public void PreOder() {
        System.out.println(this); //先输出父节点
//        递归左子树
        if (this.left != null) {
            this.left.PreOder();
        }
//        递归向右
        if (this.right != null) {
            this.right.PreOder();
        }
    }

    //中序遍历
    public void infixOder() {
//        左递归
        if (this.left != null) {
            this.left.infixOder();
        }
//        输出父节点
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOder();
        }
    }

    //后续遍历
    @SuppressWarnings({"all"})
    public void postOder() {
//        左递归
        if (this.left != null) {
            this.left.postOder();
        }
//        右递归
        if (this.right != null) {
            this.right.postOder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * (前序查找)二叉树查找
     *
     * @param no 查找的no
     * @return 如果找到就返回Node，没有则返回null
     */
    @SuppressWarnings({"all"})
    public HeroNode preOrderSeach(int no) {
        System.out.println("前序查找");
//        比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        //1.判断当前节点的左子节点是否为空。如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到节点则返回
        HeroNode resNode = null; //创建一个null节点，作为找不到时的返回值
        if (this.left != null) {
            resNode = this.left.preOrderSeach(no);
        }
        if (resNode != null) {//说明找到
            return resNode;
        }
        //1.左递归前序查找，找到则返回
        //2.当前节点的右子节点是否为空，如果为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSeach(no);
        }
        return resNode;
    }

    //中序查找
    @SuppressWarnings({"all"})
    public HeroNode infixOderSeach(int no) {
        //1.判断当前节点的左子节点是否为空
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOderSeach(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //判断当前节点是否我空
        System.out.println("中序查找");
        if (this.no == no) {
            return this;
        }
        //查找右边子节点
        if (this.right != null) {
            resNode = this.right.infixOderSeach(no);
        }
        return resNode;
    }

    //    后续查找
    @SuppressWarnings({"all"})
    public HeroNode postOderSeach(int no) {
        //1.判断当前节点的左子节点是否为空
        HeroNode resNode = null;
        //左节点不为空
        if (this.left != null) {
            resNode = this.left.postOderSeach(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //右节点不为空
        if (this.right != null) {
            resNode = this.right.postOderSeach(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //当前节点
        System.out.println("后续查找");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}