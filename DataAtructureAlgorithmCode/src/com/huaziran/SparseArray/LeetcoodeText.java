package com.huaziran.SparseArray;

public class LeetcoodeText {
    public static void main(String[] args) {
        int[] rse = {3,3};
          twoSum(rse,6);
    }

    public static int[] twoSum(int[] nums, int target) {
        int sum = 0;
        int[] rs = new int[2] ;
        for(int i = 0; i< nums.length;i++){
            for(int j = i+1; j < nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum == target){
//                    rs[0] = j;
//                    rs[1] = i;
                    System.out.print(i +" ");
                    System.out.println(j);
                }
            }
        }
        return rs;
    }


}
