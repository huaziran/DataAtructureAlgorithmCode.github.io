package com.huaziran.SparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Array {

    public static void main(String[] args)
    {

        //创建一个11行11列的二维数组
        int Array[][] = new int[11][11];
        //在下列位置中赋值
        Array[1][2] = 1;
        Array[2][3] = 2;

        //输出二维数组
        System.out.println("for循环遍历输出：");
        for (int i = 0;i<11 ;i++ )
        {
            for (int j = 0;j<11 ; j++ )
            {
                System.out.print(" " +Array[i][j]);
            }
            System.out.println();
        }

        System.out.println("foresch输出：");
        for(int [] rowa:Array){
            for (int data : rowa) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
    }

        //定义变量获取二维数组中部位0的值
        int sum = 0;
        //遍历二维数组查找
        for (int i = 0;i<11 ;i++ )
        {
            for (int j = 0;j<11 ; j++ )
            {
                if (Array[i][j] != 0)  //将数组中不为0的数组找出
                {
                    sum++;

                }
            }


        }
        System.out.println("---------------------------------");
        System.out.println("数值的个数："+sum);
        System.out.println("---------------------------------");

        //Sparse array  建立稀疏数组
        //定义变量来获取稀疏数组的行数
        int count = 0;
        int Sparray[][] = new int[sum + 1][3]; //行数由sum决定，稀疏数组列不变
        //存放第一行数组，二维数组的行列数，还有数值得个数
        Sparray[0][0] = 11;
        Sparray[0][1] = 11;
        Sparray[0][2] = sum;
        //将二维数值中不为0的值存放到稀疏数组中
        System.out.println("输出稀疏数组：");
        for (int i = 0;i<11 ;i++ )
        {
            for (int j = 0;j<11 ; j++ )
            {
                if (Array[i][j] != 0)
                {
                    count ++;    //二维数组中不为0的行和稀疏数组中的行相等
                    Sparray[count][0] = i;  //第一列
                    Sparray[count][1] = j;  //第二列
                    Sparray[count][2] = Array[i][j];  //第三列存放数值

                }
            }

        }

        //输出稀疏数组
        for (int i = 0;i<Sparray.length ;i++ )
        {
            System.out.printf("%d\t%d\t%d\t\n",Sparray[i][0],Sparray[i][1],Sparray[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复成二维数组

        //先读取稀疏数组的第一行，根据第一行数据，创建原始二维数组
        int cheseArr[][] = new int[Sparray[0][0]][Sparray[0][1]];

        //在读取稀疏数组后几行的数据（从第二行开始），并赋予原始的二维数组即可
        for (int i = 1; i < Sparray.length; i++){
            cheseArr[Sparray[i][0]][Sparray[i][1]] = Sparray[i][2];
        }

        //输出二维数组
        System.out.println("-----------");
        System.out.println("foreach输出原始数组~~");
        for (int [] row:cheseArr) {   //cheseArr = cheseArr[11][11] 先将二维数组用一维数组接收
            for (int data :row) {   //用一个变量接收一维数组
                System.out.printf("%d\t",data); //打印
            }
            System.out.println(); //打印11个换行
        }
        System.out.println("for输出原始数组：");
        for (int i = 0;i<11 ;i++ )
        {
            for (int j = 0;j<11 ; j++ )
            {
                System.out.print(" " +cheseArr[i][j]);
            }
            System.out.println();

        }

        //将稀疏数组保存到硬盘上
        File dest = new File("sparesArray.data");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dest));){
            for (int[] row :Sparray){
                for (int data : row){
                    bw.write(data+"\t");
                }
                bw.write("\n");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //从硬盘读取稀疏数组，并进行恢复
        //获取硬盘中稀疏数组的行数，并进行将其储存到一个list中
        File src = new File("sparesArray.data");
        BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(src));
            String line;
            while ((line = br.readLine()) != null){
                String[] str = line.split("\t");
                for (int i = 0;i<str.length;i++){
                    list.add(Integer.parseInt(str[i]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("---------------------");
        System.out.println("打印稀疏数组行数为：" +list.get(2)+1); //第三个元素代表不为0的元素有多少个，加一代表稀疏数组的行数

        //从硬盘读取稀疏数组到内存中：直接对之前的list进行操作
        //创建稀疏数组
        int sparesArray2[][] = new int[list.get(2) + 1][3];
        int j = 0;
        for (int i = 0;i<list.size();i = i + 3){
            sparesArray2[j][0]=list.get(i);
            sparesArray2[j][1]=list.get(i+1);
            sparesArray2[j][2]=list.get(i+2);
            j++;
        }

        System.out.println("--------------从硬盘中读取的稀疏数组------------");
        for (int []row3:sparesArray2){
            for (int data:row3){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
