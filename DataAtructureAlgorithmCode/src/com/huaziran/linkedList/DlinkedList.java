package com.huaziran.linkedList;


import java.util.Stack;

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点
    //构造器
    public HeroNode(int no,String  name,String nickname){
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
public class DlinkedList {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode head1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode head2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode head3 = new HeroNode(3, "吴用", "智多星");
        HeroNode head4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        StringLinkedList stringLinkedList = new StringLinkedList();

        //加入
        stringLinkedList.add(head1);
        stringLinkedList.add(head4);
        stringLinkedList.add(head3);
        stringLinkedList.add(head2);

        System.out.println("===============安照编号添加节点===================");
        //安照编号添加
//        stringLinkedList.addByOrder(head1);
//        stringLinkedList.addByOrder(head4);
//        stringLinkedList.addByOrder(head3);
//        stringLinkedList.addByOrder(head2);
        //stringLinkedList.addByOrder(head2);   //测试不能添加no相同的节点
        //显示一把
        System.out.println("=======链表一========");
        stringLinkedList.list();

        //测试修改代码
        HeroNode newHeroNode = new HeroNode(2, "小路", "玉琴");
        stringLinkedList.update(newHeroNode);
        System.out.println("==============修改后的链表：==========");
        stringLinkedList.list();

        //删除一个节点
//        stringLinkedList.delete(1);
//        System.out.println("============删除后的链表：===========");
//        stringLinkedList.list();

        //题目1：c输出节点个数
        System.out.println("========题目1：c输出节点个数=========");
        System.out.println("节点个数为(不带头节点)：" + getlength(stringLinkedList.getHead()));

        //题目二：b、找到倒数第k个节点
        System.out.println("==========题目二：找到倒数第k个节点===========");
        System.out.println(fandLastIndexNode(stringLinkedList.getHead(), 3));

        //题目三：测试反转
//        System.out.println("==========题目三：测试反转========");
//        reverselist(stringLinkedList.getHead());
//        stringLinkedList.list();

        //题目四：逆序打印链表
        System.out.println("===========题目四：逆序打印链表==============");
        reversePrint(stringLinkedList.getHead());

        //题目五：合并单链表
        System.out.println("==============题目五：合并单链表============");
        mergeLinklist(stringLinkedList.getHead(), stringLinkedList.getHead());
        stringLinkedList.list();

    }

    // 单链表面试题：
    //题目一、获取单链表节点的个数 (带头节点的链表，需求不统计头节点)
    //题1：a、建立获取方法
    public static int getlength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }

    //题目二：查找链表中倒数第k个节点（新浪面试题）
    //思路： 总链表长度-k(index)  可得到改节点
    //题目2：a、创建查找最后一个节点方法
    public static HeroNode fandLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null; //没有找到
        }
        int NodeSize = getlength(head);  //利用题目一的getlength（）方法获取链表长度赋值给NodeSize
        //做一个校验，让我们得到index是有效值
        if (index < 0 || index > NodeSize) {
            return null;
        }
        HeroNode currNode = head.next;   //定义一个辅助变量（指针），方便我们查找
        //循环遍历查找
        for (int i = 0; i < NodeSize - index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    //题目三:单链表的反转
    public static void reverselist(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个变量指针，帮助我们遍历链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reversehead = new HeroNode(0, "", "");
        //遍历原来的链表，霉遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next; //先将暂时保存当前节点，后面用
            cur.next = reversehead.next; //将cur的下一个节点指向新的链表的最前端
            reversehead.next = cur; //将cur连接到新的链表上
            cur = next; //让cur后移
        }
        //将head.next 指向reverseHead.next
        head.next = reversehead.next;
    }

    //题目四：逆序打印单链表
    //思路：可以利用栈这个数据结构，将各个节点压入栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            return;
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的 所有节点压入栈
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;  //指针后移，这样就能连续压入下一个节点
        }
        //将栈中的节点进行打印，pop出站
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //pop出栈
        }
    }


    //题目五：合并两个链表(目前未成功解决)
        //思路找到第一个链表的最后，将第二个链表（不包活头节点）接入到head最后
    public static HeroNode mergeLinklist(HeroNode head,HeroNode head2){
        //判断链表是否为空,当其一个为空，则返回另外一个
        if (head.next == null) {
            return head2.next;
        }else if (head2 == null){
            return head.next;
        }
//        HeroNode cur = head.next;
//        while (cur != null){
//            if (cur.next == null){  //说明已经遍历到head最后
//                break;
//            }
//            cur = cur.next;
//        }
//        cur.next = head2.next;

        //定义一个变量指针，帮助我们遍历链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reversehead = new HeroNode(0, "", "");
        //遍历原来的链表，霉遍历一个节点，就将其取出，并放在新的链表reversehead 的最前端
        while (cur != null) {
            next = cur.next; //先将暂时保存当前节点，后面用
            cur.next = reversehead.next; //将cur的下一个节点指向新的链表的最前端
            reversehead.next = cur; //将cur连接到新的链表上
            if (cur.next == null){
                HeroNode cur1 = head2.next;
                HeroNode next1 = null;
             while (cur1 != null){
                next1 = cur1.next; //先将暂时保存当前节点，后面用
                cur1.next = reversehead.next; //将cur的下一个节点指向新的链表的最前端
                reversehead.next = cur1; //将cur连接到新的链表上
                cur1 = next1; //让cur后移
             }
                cur = next; //让cur后移
                System.out.println(cur);
            }
        }
        return reversehead.next;
}



}
//定义StringLinkedList管理我们的英雄
class  StringLinkedList{
    //先初始化头节点
    private HeroNode head = new HeroNode(0,"","");
    //题1：b、返回头节点给getlength方法
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前；链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为头节点不能动，所以我们需要一个辅助变量temp
        HeroNode  temp = head;
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
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

     //第二种方式添加英雄时，根据排名将英雄插入到指定的位置
    //如果有这个排名，则添加失败，并给出提示
     public void addByOrder(HeroNode heroNode){
         //因为头节点不能动，因此我们仍要通过一个辅助节点（变量）来帮助我们找到要添加的位置
         //因为单链表，因为我们找到temp是位于添加位置的前一个节点，否则插入不了
         HeroNode temp = head;
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
             heroNode.next = temp.next;
             temp.next = heroNode;
         }
     }

     //修改节点的信息，根据no编号来修改，及编号不能改
    public void update(HeroNode newHeroNode){
         //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;

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

    //删除节点
    //思路：
    //1、head不能动，因此我们需要一个辅助节点temp找到代删除的节点的前一个节点
    //2、说明我们在比较时，是temp.next.no和需要删除的节点的no比较
    public void delete(int no) {
            HeroNode temp = head;   //构建辅助节点
            boolean flag = false;   //作为判断是否找到满足条件节点的判断
            while (true){
                if (temp.next == null){  //找到最后也没有找到
                    break;
                }
                if (temp.next.no == no){  //找到
                    flag = true;    //找到
                    break;
                }
                temp = temp.next; //指正后移：查找
            }
            //判断flag
        if (flag){//找到删除的no了
            temp.next = temp.next.next; //删除节点：直接跳过删除节点
        }else{
            System.out.printf("删除的节点%d不存在",no);
        }
    }

     //显示链表
    public void list(){
         //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要 一个辅助变量来遍历
        HeroNode temp = head.next;
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
}

