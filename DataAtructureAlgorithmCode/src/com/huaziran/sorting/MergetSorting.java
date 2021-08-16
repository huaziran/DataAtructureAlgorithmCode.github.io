package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})

//归并排序
public class MergetSorting {
    public static void main(String[] args) {
//        int[] arry = {8, 4, 5, 7, 1, 3, 6, 2};
//        int temp[] = new int[arry.length];  //额外的空间
//        mergeSorting(arry, 0, arry.length - 1, temp);
//        System.out.println(Arrays.toString(arry));

        int[] arrys = new int[8000000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }
        int temp[] = new int[arrys.length];

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);

        mergeSorting(arrys,0,arrys.length - 1,temp);

        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);
//        System.out.println(Arrays.toString(arrys));
    }

    public static void mergeSorting(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSorting(arr, left, mid, temp);
            //向右递归
            mergeSorting(arr, mid + 1, right, temp);
            //到合并时
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//        System.out.println("第" + "次拷贝");
        int i = left;  //初始化左边索引i
        int j = mid + 1; //右边有序序列的开始索引
        int t = 0; //作为中转数组的索引

        //1、先把左右两边的数据安照规则填充到temp数组，直到左右两边的有序序列，有一边处理完为止
        while (i <= mid && j <= right) {
            //如果左边的数小于或等于右边的数，就将左边的数拷贝到temp中，然后指针后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else {  //反之arr[i] >= arr[j] 将右边的数据拷贝到temp中；
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }
        //2、把有剩余数据一边依次全部填充到temp中
        while (i <= mid) { //说明左边的还有剩余元素，就将剩余的元素依次拷贝到temp中华
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) { //说明右边边的还有剩余元素，就将剩余的元素依次拷贝到temp中华
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //3、将temp的元素拷到原数组,并不是拷贝的8个
        t = 0;
        int tempLeft = left;
//        System.out.println("tempLeft=" + tempLeft + " right" + right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
