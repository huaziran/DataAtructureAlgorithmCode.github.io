package com.huaziran.search;

import java.util.Arrays;

//插值查找
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        int value = insertValue(array, 0, array.length - 1, 50);
        System.out.println("索引: " + value);
        System.out.println("==============");
        int[] arry = {1, 3, 5, 6, 7, 7, 7, 7, 8, 9, 10, 11};
        int val = insertValue(array, 0, arry.length - 1, 7);
        System.out.println("索引: " + val);

    }

    /**
     * @param arr       需要查找的数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 查找的值
     * @return 返回索引
     */
    public static int insertValue(int[] arr, int left, int right, int findValue) {
        System.out.println("查找");
        if (left > right || arr[0] > findValue || arr[arr.length - 1] < findValue) {
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findValue > midVal) { //右递归
            return insertValue(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {  //左递归
            return insertValue(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
