package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})
public class BubbleSorting {

    public static void bubbleSort(int[] arr) {
        int temp = 0;  //第三方容器，用于交换
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) { //表示第几次循环
            for (int j = 0; j < arr.length - i - 1; j++) {  //进行第i次循环的前一位与后一位的循环比较
                if (arr[j] > arr[j + 1]) { //判断比较
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
//            System.out.println(i);
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 2, 7, 8};
        BubbleSorting bubbleSorting = new BubbleSorting();
        bubbleSort(arr);

        int[] arrys = new int[80000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);
        bubbleSort(arrys);
        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);


//        int temp = 0;  //第三方容器
//        boolean flag = false;
//        for (int i = 0; i < arr.length; i++) { //表示第几次循环
//            for (int j = 0; j < arr.length - i -1; j++){  //进行第i次循环的前一位与后一位的循环比较
//                if(arr[j] > arr[j +1]){ //判断比较
//                    flag = true;
//                    temp = arr[j +1];
//                    arr[j +1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//            System.out.println(i);
//            if (!flag){
//                break;
//            }else{
//                flag = false;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }
    }
}

