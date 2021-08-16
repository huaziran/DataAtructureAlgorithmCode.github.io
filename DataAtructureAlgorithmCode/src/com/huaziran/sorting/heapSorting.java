package com.huaziran.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings({"all"})
public class heapSorting {
    public static void main(String[] args) {
        //测试速度
        int[] arrys = new int[8000000];
        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date1r = simpleDateFormat.format(date1);
        System.out.println("排序时间前：" + date1r);
        heapSorting(arrys);
        Date date2 = new Date();
        String date2r = simpleDateFormat.format(date2);
        System.out.println("排序时间后：" + date2r);

        int arr[] = {4, 6, 8, 5, 9,-11,-3,43,12,34,-55};
        heapSorting(arr);
    }

    //                        0:4
//                 1:6           2:8
//            3:5     4:9
//
    public static void heapSorting(int[] arr) {
        System.out.println("堆排序");
        int temp = 0;
        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次调整" + Arrays.toString(arr));//第一次
//                        0:4
//                 1:9          2:8
//            3:5     4:6
//
        //完整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
//        System.out.println("完整调整" + Arrays.toString(arr));//第一次
//       将堆项元素与末尾元素交换，将最大元素"沉"到数组末端;
//      重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素,
//      反复执行调整+交换步骤，直到整个序列有序。
        for (int j = arr.length - 1; j >= 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
//        System.out.println("最后输出" + Arrays.toString(arr));//第一次
    }

    /**
     * 功能：完成将以i对应的叶子节点的数调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 有多找个元素进行调整，length是在逐渐的减小
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素的值保存在临时变量
        //k = i * 2 + 1;是节点的左节点
        //k = k * 2 + 1 是k节点的左节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子节点的值小于右子节点的值
                k++;//指向右子节点
            }
            if (arr[k] > temp) {//如果子节点大于父节点
                arr[i] = arr[k]; //将较大的值赋值给当前节点
                i = k;//i指向k,继续循环比较
            } else {
                break;
            }
            //当for循环结束后，我们已将以i为父节点的数的最大值放到了顶部
            arr[i] = temp;
        }
    }
}
