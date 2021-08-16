package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})

//插入排序
public class InsertSorting {

    public static void main(String[] args) {
        int[] arry = {4,2,5,8,1};
        insertSorting(arry);
        System.out.println(Arrays.toString(arry));

        int[] arrys = new int[80000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);
        insertSorting(arrys);
        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);
    }

    public static void insertSorting(int[] arry){
        for (int i = 1; i < arry.length; i++) { //控制组
            int insertValue = arry[i]; //
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insertValue > arry[insertIndex]){
                arry[insertIndex + 1] = arry[insertIndex];
                insertIndex--;
            }
            //这里while循环出来insertIndex已经变成了-1所以找到位置时insertIndex + 1
            if (insertIndex + 1 != i){  //相当于while没有进入
                arry[insertIndex + 1] = insertValue;
            }
        }
    }
}
