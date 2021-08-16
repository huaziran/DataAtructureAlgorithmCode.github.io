package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})

public class RadixSorting {
    public static void main(String[] args) {
        int[] arry = {53, 3, 542, 748, 14, 214};
        radixSorting(arry);

        int[] arrys = new int[8000000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);
        radixSorting(arrys);
        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);

    }

    public static void radixSorting(int[] arr) {
        //获得最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //得到最大位数
        int maxLength = (max + "").length();

        //用二维数组表示10个桶，一个代表桶的一维数组
        int[][] bucket = new int[10][arr.length]; //前面10代表10个桶，后面arr.length代表一维数组位数

        //定义一个一维数组来记录桶中实际放了多少个数据和放入第几个同
        int[] bucketElenmentCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) { //依次遍历数组及取出
                //取出每个元素的个位值
                int digitofElenmrnt = arr[j] / n % 10;
                //将取出的数放入第n位（桶）中的第几位数
                bucket[digitofElenmrnt][bucketElenmentCounts[digitofElenmrnt]] = arr[j];
                bucketElenmentCounts[digitofElenmrnt]++;
            }
            //安照这个桶的顺序放入原数组
            int index = 0; //辅助变量
            //遍历每一个桶，并将桶中的数组放入原数组
            for (int k = 0; k < bucketElenmentCounts.length; k++) {
                //如果桶中有数据，我们才放入
                if (bucketElenmentCounts[k] != 0) {
                    //循环该桶中第k个桶，有数据的通
                    for (int l = 0; l < bucketElenmentCounts[k]; l++) {
                        //取出数据放入
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElenmentCounts[k] = 0; //!!!!!置控，不然会数组越界
            }
//            System.out.println("第" + i + "轮" + Arrays.toString(arr));
        }


    }
}
