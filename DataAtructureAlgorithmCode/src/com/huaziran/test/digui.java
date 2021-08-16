package com.huaziran.test;

public class digui {

    public static void main(String[] args) {
        digui test = new digui();
        test.test(10);
    }
    public void test(int x) {
        if ( x > 2){
            test(x - 2);
        }
        System.out.println(x + " ");
    }

}
