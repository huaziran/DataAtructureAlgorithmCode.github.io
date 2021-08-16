package com.huaziran.search;


import java.util.ArrayList;
import java.util.List;

public class OrderSearch {

    public static void main(String[] args) {
        int[] arry = {1, 7, 3, 5, 6, 7, 7, 7, 7, 8, 9, 7, 10};
        List<Integer> list = orderSearch(arry, 7);
        System.out.println(list);
    }

    //线性查找
    public static ArrayList<Integer> orderSearch(int[] arr, int findVal) {
        ArrayList<Integer> indexVal = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findVal) {
                indexVal.add(i);
            }
        }
        return indexVal;
    }
}
