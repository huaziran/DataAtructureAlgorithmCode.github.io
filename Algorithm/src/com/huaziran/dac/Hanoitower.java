package com.huaziran.dac;

//分治算法
public class Hanoitower {
    public static void main(String[] args) {

        hanoitower(5,'A','B','C');

    }
    //案例：汉罗塔
    public static void hanoitower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从： " + a + "->" + c);
        } else {
            //先把除第一个盘及上面的盘A->B，用到c
            hanoitower(num - 1, a, c, b);
            //把最下面的盘A-C
            System.out.println("第" + num + "个盘从： " + a + "->" + c);
            //把B塔中的移到C：B->C,用到a
            hanoitower(num - 1, b, a, c);
        }
    }
}

