package com.huaziran.test;

public class HanoiTower {

    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(5, 'A', 'B', 'C');
    }
}
class Tower{
    public void move(int num,char a,char b,char c){
        if (num == 1){
            System.out.println(a + "->" + c);
        }else{
//            1、先移动上面所有的盘到b，借助c
            move(num -1,a,c,b);
//            2、把最下面的这个盘，移动到c
            System.out.println(a + "->" + c);
            //3、再把b塔的所有盘，移动到c，借助a
            move(num - 1,b, a, c);
        }

    }

}