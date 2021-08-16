package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})

public class QuickSorting {
    public static void main(String[] args) {

//        int[]  arry = {23,13,54,-8,-75,45,-7};
//        quickSorting(arry,0,arry.length - 1);
//        System.out.println(Arrays.toString(arry));

        int[] arrys = new int[8000000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);

        quickSorting(arrys,0,arrys.length - 1);

        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);


    }

    public static  void quickSorting(int[] arr,int left,int right){
        int l = left;  //左下标
        int r = right; //右下标
        int temp = 0; //
        int prvot = arr[(left + right) / 2];  //中间数
        while(l < r){
            //寻找左边小于中间值的数
            while(arr[l] < prvot){
                l += 1;
            }
            //寻找右边小于中间值的数
            while(arr[r] > prvot){
                r -= 1;
            }
            //如果l>=r表示已经查找完毕
            if (l >= r){
                break;
            }
            //找到之后进行交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换之后左边的数等于右边的数
            if(arr[l] == prvot){
                r -= 1;
            }
            //交换之后左边的数等于左边的数
            if (arr[r] == prvot){
                l += 1;
            }
        }
//        找到相同的位置
        if (l == r){
            l += 1;
            r -= 1;
        }

        //左递归
        if(left < r){
            quickSorting(arr,left,r);
        }
        //右递归
        if (right > l){
            quickSorting(arr,l,right);
        }

    }
}
