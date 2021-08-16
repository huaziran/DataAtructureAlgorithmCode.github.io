package com.huaziran.test;

public class yanghuisanjiao {
    public static void main(String[] args) {
        //杨辉三角
        yanghui(20);
    }
    public static void yanghui(int number){
//        创建二维数组
        int[][] yanghui = new int[number][];
//        遍历二维数组元素
        for (int i = 0; i < yanghui.length; i++){
            yanghui[i] = new int[i +1 ]; //创建二维数组中的元素，及以为数组
            for (int j = 0; j < yanghui[i].length;j++){ //遍历一维数组
                //将开始与末尾置1
                    if (j == 0 || j == yanghui[i].length-1){
                    yanghui[i][j] = 1;
                }else{
                        //杨辉三角的性质
                    yanghui[i][j] = yanghui[i-1][j] + yanghui[i -1 ][j -1];
                }
            }
        }
        //输出
        for (int i = 0; i < yanghui.length ;i++){
            for (int k = 0; k < number - i; k++){
                System.out.print(" ");
            }
            for (int j = 0; j < yanghui[i].length;j++){
                System.out.print(yanghui[i][j] + " ");
            }
            System.out.println();
        }
    }
}

