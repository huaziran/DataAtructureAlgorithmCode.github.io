package com.huaziran.linkedList;


//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点  默认为null
    public HeroNode2 pre; //指向前一个节点 默认为null
    //构造器
    public HeroNode2(int no,String  name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，我们重写tostring
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

//创建双向链表
class DoubleLinkList{
    //先初始化头节点
    private HeroNode2 head = new HeroNode2(0,"","");
    //题1：b、返回头节点给getlength方法
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要 一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while(true){
            if (temp == null){
                break;
            }
            //輸出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //添加节点
    public void add(HeroNode2 heroNode){
        //因为头节点不能动，所以我们需要一个辅助变量temp
        HeroNode2  temp = head;
        //遍历，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;  //退出循环
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //将退出while循环后，temp就指向了链表的最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //安照顺序添加双向链表
    //第二种方式添加英雄时，根据排名将英雄插入到指定的位置
    //如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode2 heroNode){
        //因为头节点不能动，因此我们仍要通过一个辅助节点（变量）来帮助我们找到要添加的位置
        //因为单链表，因为我们找到temp是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
        HeroNode2 next = null;
        boolean flag = false;  //flag标志添加的编号是否存在，默认false；
        while(true){
            if (temp.next == null){  //说明temp在链表最后
                break;
            }
            if (temp.next.no > heroNode.no){ //位置找到，就在temp的后面插入
                break;
            }else if (temp.next.no == heroNode.no){//说明编号存在
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移
        }
        //判断flag的值
        if (flag){
            System.out.printf("插入的编号: %d 已存在\n",heroNode.no);
        }else{
            //插入到链表中
            next = temp.next;
            heroNode.next = temp.next;
            temp.next = heroNode;
            heroNode.pre = temp;
            if (next != null){
                temp.next.pre = heroNode;
            }
        }
    }

    //修改双向链表（修改方法和单链表一样）
    //修改节点的信息，根据no编号来修改，及编号不能改
    public void update(HeroNode2 newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;

        boolean flag = false; //表示是否找到该节点
        while(true){
            if(temp == null){
                break; //已经遍历玩链表了
            }
            if (temp.no ==  newHeroNode.no){
                //已经找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.printf("没有找到%d节点/n",newHeroNode.no);
        }

    }

    //双向链表删除节点
        //我们可以直接找到要删除的节点直接删除
    public void delete(int no) {

        //判断当前链表是否为空
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;   //构建辅助节点
        boolean flag = false;   //作为判断是否找到满足条件节点的判断
        while (true){
            if (temp == null){  //找到最后也没有找到
                break;
            }
            if (temp.no == no){  //找到
                flag = true;    //找到
                break;
            }
            temp = temp.next; //指正后移：查找
        }
        //判断flag
        if (flag){//找到删除的no了
           // temp.next = temp.next.next; //删除节点：直接跳过删除节点[单向链表]
            temp.pre.next = temp.next;
           //当删除最后一个节点是有风险：不在执行，否则出现空指针异常,so进行判断
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("删除的节点%d不存在",no);
        }
    }



}


public class DoubleLinkListDemo {

    public static void main(String[] args) {
        System.out.println("=======测试双向链表=========");
        //创建节点
        HeroNode2 head1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 head2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 head3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 head4 = new HeroNode2(4, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        //直接添加
//        doubleLinkList.add(head1);
//        doubleLinkList.add(head2);
//        doubleLinkList.add(head3);
//        doubleLinkList.add(head4);

        //顺序添加链表
        doubleLinkList.addByOrder(head1);
        doubleLinkList.addByOrder(head4);
        doubleLinkList.addByOrder(head3);
        doubleLinkList.addByOrder(head2);
        doubleLinkList.addByOrder(head2);   //测试不能添加no相同的节点
        doubleLinkList.list();

        //修改
      HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
      doubleLinkList.update(newHeroNode);
        System.out.println("==========修改后的链表===========");
        doubleLinkList.list();


        //删除
        doubleLinkList.delete(1);
        System.out.println("============删除后的链表==========");
        doubleLinkList.list();


    }

}

