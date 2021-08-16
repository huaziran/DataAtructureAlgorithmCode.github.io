package com.huaziran.test;

public class constructor {
    public static void main(String[] args) {

        Person p1 = new Person();
        System.out.println("name: " + p1.name + " age " + p1.age);

        Person p2 = new Person("xiaogn", 20);
        System.out.println("name " + p2.name + " age " + p2.age);
    }
}
class Person{
    String name;
    int age;
    public Person(){
        age = 18;
    }
    public Person(String Pname,int Page){
        name = Pname;
        age = Page;
    }
}
