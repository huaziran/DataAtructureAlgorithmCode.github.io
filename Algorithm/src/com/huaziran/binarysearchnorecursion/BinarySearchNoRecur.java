package com.huaziran.binarysearchnorecursion;

public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] array = {1,3,5,6,8,9,12,24};
        int index = binarySearch(array, 9);
        System.out.println(index);
    }

    //    二分查找非递归
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1;//向右边查找
            }
        }
        return -1;
    }

}
