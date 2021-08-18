package com.huaziran.dynamic;

@SuppressWarnings({"all"})
//动态规划
public class KnapsackProblem {
    //背包问题
    public static void main(String[] args) {
        int[] w = {1, 4, 3}; //物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价格
        int m = 4; //背包的容量
        int n = val.length;//物品的个数

        //记录商品情况
        int[][] path = new int[n + 1][m + 1];
        //创建二维数组
        int[][] v = new int[n + 1][m + 1];

        //初始化第一列
        for (int i = 0; i < v.length; i++) {
            v[0][i] = 0;
        }
        //初始化第一行
        for (int i = 0; i < v[0].length - 1; i++) {
            v[i][0] = 0;
        }

        //根据前面得到公式动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) { //w[i]:是代表重量， j：代表重量从1开始到最大重量
                    v[i][j] = v[i - 1][j];//将上一行的值赋给下一行
                } else {
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出二维数组
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        //打印商品（path）
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
//        for (int i = 0; i < v.length; i++) {
//            for (int j = 0; j < v[i].length; j++) {
//                if (path[i][j]==1){
//                    System.out.printf("第%d个商品放入到背包中\n",i);
//                }
//            }
//        }

        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1; //列的最大下标
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包中\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
