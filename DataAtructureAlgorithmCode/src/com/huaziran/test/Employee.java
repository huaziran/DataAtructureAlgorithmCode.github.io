package com.huaziran.test;

public class Employee {
    public static void main(String[] args) {

    }
}

class Employee2{
    String name;
    char gender;
    int age;
    String job;
    double sal;

    public Employee2(String name, double sal){
        this.name = name;
        this.sal = sal;
    }
    public Employee2(String name,char gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee2(String name, char gender, int age, String job, double sal) {
            this(name, gender, age);
            this.name = name;
            this.sal = sal;
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//        this.job = job;
//        this.sal = sal;
    }
}
