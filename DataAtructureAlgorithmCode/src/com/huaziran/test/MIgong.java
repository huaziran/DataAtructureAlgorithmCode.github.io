package com.huaziran.test;

public class MIgong {

    public static void main(String[] args) {

//        创建一个二维数组当做地图迷宫
        int[][] array = new int[8][7];
        //设置墙
        array[3][1] = 1;
        array[3][2] = 1;
        array[2][2] = 1;
        for (int i = 0; i < array.length - 1; i++){ //将边上的边都设置成墙
            array[0][i] = 1;
            array[7][i] = 1;
            array[i][0] = 1;
            array[i][6] = 1;
        }
        System.out.println("==========找路之前==========");
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        T t = new T();  //实例化
        t.migong(array,1,1); //传入初始值
        System.out.println("===============找路之后=============");
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }

    }
}

class T{
    public boolean migong(int[][] array, int i,int j){
        if(array[6][5] == 2){ //设置终点
            return true;
        }else{
            if (array[i][j] ==0 ){
                //下->右->上->左
                array[i][j] = 2; //假设该点为2，能走通
                if (migong(array,i + 1, j)){
                    return true;
                }else if (migong(array,i,j + 1)){
                    return true;
                }else if(migong(array,i - 1,j)){
                    return true;
                }else if(migong(array,i, j - 1)){
                    return true;
                }else{
                    array[i][j] = 3;  //走不通 的路设置为3
                    return false;
                }
            }else{//要么1,2,3，选择FALSE。走不通
               return false;
            }
        }
    }
}
