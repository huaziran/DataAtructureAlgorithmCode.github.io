package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})

public class SelectSorting {
    public static void main(String[] args) {

        int[]  arr = {3,5,2,6,7,1};
        selectSorting(arr);
        System.out.println(Arrays.toString(arr));

        int[] arrys = new int[80000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);
        selectSorting(arrys);
        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);

    }
  //选择排序
    public static void selectSorting(int[] arry){
        for(int i = 0; i < arry.length; i ++){
            int index = i;
            int min = arry[i]; //假设最小值，后面进行替换
            boolean flag = false;
            for (int j = i + 1; j < arry.length; j++) { //查找最小值
                if (min > arry[j]){ //进行比较，判断出最小值
                    flag = true;
                    index = j;
                    min = arry[j];
                }
            }
            if (flag) {  //如果循环查找之后 if (min < arry[j])没有执行，即当前值为最小值
                //交换最小值位置与当前位置（即上一次查找到的最小值）
                arry[index] = arry[i];
                arry[i] = min;
            }
        }
    }
}
