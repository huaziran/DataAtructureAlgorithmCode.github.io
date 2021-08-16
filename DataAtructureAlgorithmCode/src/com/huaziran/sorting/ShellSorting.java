package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})

//希尔排序
public class ShellSorting {
    public static void main(String[] args) {
        int[] arry = {2, 4, 6, 1, 7, 9, 5, 8, 3, 0};
        shellSorting2(arry);
        System.out.println(Arrays.toString(arry));

        int[] arrys = new int[8000000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);
        shellSorting2(arrys);
        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);
//        System.out.println(Arrays.toString(arrys));
}

    public static void shellSorting(int[] arr) {
        int temp = 0;
        for (int gep = arr.length / 2; gep > 0; gep /= 2) { //控制第几轮

            for (int i = gep; i < arr.length; i++) { //控制组数
                //根据大小交换位置，这里组数会根据第n轮的不同不同，每个组中的数据个数也不同
                //1轮  组：5 个数： 2
                //2轮  组：2 个数： 5
                //3轮  组：1 个数：10
                //规律：组 * 个数 = 数组长度
                for (int j = i - gep; j >= 0; j -= gep) { //控制个数
                    if (arr[j] < arr[j + gep]) {
                        temp = arr[j + gep];
                        arr[j + gep] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void shellSorting2(int[] arr) {

        for (int gep = arr.length / 2; gep > 0; gep /=2){ //控制第几轮
            for (int i = gep; i < arr.length; i++){  //gep为步数
                int index = i;  //用于控制数组下标
                int arrys = arr[i];  //先保存该数据
                if (arr[index] < arr[index - gep]) {
                    while(index - gep >= 0 && arrys < arr[index - gep]){
                        arr[index] = arr[index - gep];
                        index -= gep;
                    }
                    arr[index] = arrys;
                }
            }
        }
    }
}
