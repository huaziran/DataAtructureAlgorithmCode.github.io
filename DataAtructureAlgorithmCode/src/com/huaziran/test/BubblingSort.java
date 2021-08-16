package com.huaziran.test;

public class BubblingSort {

    public static void main(String[] args) {
        //冒泡排序
        int[] sarr = {12, 88, 23, 4, 45, 67};
        int[] sarr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        maopao(sarr1);
    }

    public static void maopao(int[] sarr) {
        int ln = sarr.length;
        int[] array = new int[sarr.length];
        int ar = 0;
        boolean flag = true;
        for (int i = 0; i < ln - 1; i++) {
            for (int j = 0; j < ln - i - 1; j++) {
                if (sarr[j] > sarr[j + 1]) {
                    ar = sarr[j];
                    sarr[j] = sarr[j + 1];
                    sarr[j + 1] = ar;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("已经排序，跳出循环");
                break;
            }

            System.out.println("第" + i + "轮");
            for (int k = 0; k < ln; k++) {
                System.out.print(sarr[k] + " ");
            }
        }
        System.out.println("最后结果：");
        for (int k = 0; k < ln; k++) {
            System.out.print(sarr[k] + " ");
        }
    }
}
