package com.huaziran.pkj;

import java.util.Arrays;
public class Import01 {
    public static void main(String[] args) {
        int[] array = {12,32,-42,2,4,56};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
