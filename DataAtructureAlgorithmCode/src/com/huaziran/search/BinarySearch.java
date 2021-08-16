package com.huaziran.search;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class BinarySearch {

    public static void main(String[] args) {
        int[] arry = {1, 3, 5, 6, 7, 7, 7, 7, 8, 9, 10, 11};
        int result = binarySearch(arry, 0, arry.length - 1, 11);
        System.out.println("result=" + result);

        System.out.println("===================");
        List<Integer> resultList = binarySearch2(arry, 0, arry.length - 1, 7);
        System.out.println(resultList);


    }

    /**
     * @param arr     需要查找的数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 需要查找的值
     * @return 输出查找的值的下标
     */
    //二分查找
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        //当left >right 时，说明遍历了整个数组，但是没有找到
        //向右递归时，left 相当于 mid+1
        //向左递归时。right相当于 mid-1
        //无线接近
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else { //
            return mid;
        }
    }

    /*
  如果数组中有相同值，查找出相同值的所有下标，
  思路分析：
  1.查找mid的索引值，不要马上返回
  2.向mid索引的左边扫描，将所有满足条件的元素的下标加入到一个ArrayList集合中
  3.向mid索引的右边扫描，将所有满足条件的元素的下标加入到一个ArrayList集合中
  4.返回一个ArrayList
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left >right 时，说明遍历了整个数组，但是没有找到
        //向右递归时，left 相当于 mid+1
        //向左递归时。right相当于 mid-1
        //无线接近
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else { //
            ArrayList<Integer> resIdexList = new ArrayList<>();
            //向左扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIdexList.add(temp);
                temp = temp - 1;
            }
            resIdexList.add(mid);

            //向右扫描
            int temp1 = mid + 1;
            while (true) {
                if (temp1 > arr.length - 1 || arr[temp1] != findVal) { //退出
                    break;
                }
                resIdexList.add(temp1);
                temp1 = temp1 + 1;
            }
            return resIdexList;
        }
    }

}

