package com.huaziran.linkedList;

public class annular_Josephu {

    //测试环形链表
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();
        circleSingleLinkList.addBoy(335);//加入5个小孩
        circleSingleLinkList.showBoy();

        //测试出圈
        circleSingleLinkList.contBoy(5, 6, 335);
    }

}

//创建一个环形链表
class CircleSingleLinkList{
    //创建一个first节点，当前没有编号
    private Boy first = new  Boy(-1);
    //添加小孩节点，构成一个环形的链表
    public void addBoy(int nums){
        //nums做一个数据校验
        if (nums < 1){
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++){
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if( i== 1){
                first = boy;
                first.setNext(first); //构成环形
                curBoy = first; //让curBoy指向第一个小孩
            }else{
                curBoy.setNext(boy); //
                boy.setNext(first);
                curBoy = boy;
            }

        }

    }

    //遍历当前环形链表
    public void showBoy(){
        //判断是否为空
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此需要辅助指针
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext(); //指针后移
        }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param contNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    //根据用户的输入，计算出小孩出圈的顺讯
    public void contBoy(int startNo,int contNum,int nums){
        //对数据进行校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误：");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //需要一个辅助指针helper，指向链表的最后一个节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k  - 1次
        for (int j = 0; j < startNo - 1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和helper 指针同时移动 m - 1次，然后出圈
        while (true){
            if (helper == first){ //说明只有一个人
                break;
            }
            //让first hehelper 指针同时移动 contNum - 1
            for (int i = 0; i < contNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时让小孩出圈
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);   //helper.next = first
        }
        System.out.printf("最后一个小孩%d\n",helper.getNo());
    }
}

//创建一个Boy类，表示一个节点
class Boy{
    private int no;//编号
    private Boy next;  //指向下一个节点，默认为空
    public Boy(int no){
        this.no = no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }


}
