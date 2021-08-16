package com.huaziran.tree;
@SuppressWarnings({"all"})
public class BinaryTreeDome {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode1 = new HeroNode(2, "吴用");
        HeroNode heroNode2 = new HeroNode(3, "卢俊义");
        HeroNode heroNode3 = new HeroNode(4, "林冲");
        HeroNode heroNode4 = new HeroNode(5, "关胜");

        //手动创建二叉树
        root.setLeft(heroNode1);
        root.setRight(heroNode2);
        heroNode2.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        binaryTree.setRoot(root);

//                     1:宋江
//              2:吴用        3：卢俊义
//                       5:关胜       4：林冲
//
        System.out.println("====前序遍历===="); //12354
        binaryTree.preOrder();
        System.out.println("====中序遍历====");//21534
        binaryTree.infixOder();
        System.out.println("====后续遍历====");//25431
        binaryTree.postOrder();

        System.out.println("====前序查找(4次)=====");
        HeroNode resNode = binaryTree.preOrderSeach(5);
        if (resNode != null) {
            System.out.printf("no = %d name = %s \n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("没有找到");
        }

        System.out.println("====中序查找(3次)=====");
        HeroNode resNode1 = binaryTree.infixOderSeach(5);
        if (resNode1 != null) {
            System.out.printf("no = %d name = %s\n", resNode1.getNo(), resNode1.getName());
        } else {
            System.out.println("没有找到");
        }

        System.out.println("====后序查找(2次)=====");
        HeroNode resNode2 = binaryTree.postOderSeach(5);
        if (resNode2 != null) {
            System.out.printf("no = %d name = %s\n", resNode2.getNo(), resNode2.getName());
        } else {
            System.out.println("没有找到");
        }

        System.out.println("删除之前");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除之后");
        binaryTree.preOrder();
    }
}

//创建二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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

//创建节点
class HeroNode {
    private int no; //
    private String name; //
    private HeroNode left; //默认为空
    private HeroNode right;//默认为空


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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
