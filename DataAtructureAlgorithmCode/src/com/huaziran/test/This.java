package com.huaziran.test;

public class This {
    public static void main(String[] args) {
        Persons P1 = new Persons("KEBI", 20);
        Persons p2 = new Persons("奥尼尔", 20);
        P1.intfo();
        p2.intfo();
    }
}
class Persons {
    String name;
    int age;
    public void intfo(){
        System.out.println("name:" + name + " age:" + age);
    }
    public Persons(String name,int age){
        this.name = name;
        this.age = age;
    }

}
