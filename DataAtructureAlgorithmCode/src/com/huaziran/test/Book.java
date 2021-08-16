package com.huaziran.test;

public class Book {
    public static void main(String[] args) {
        Boybook p1 = new Boybook("wangzhe", 300);
        System.out.println(" booknameYET： " + p1.name + " priceYET: " + p1.price);
        p1.updatePrice();
//        p1.infotow();
        p1.info();
    }
}
class Boybook{
    String name;
    double price;

    public Boybook(String name,double price){
        this.name = name;
        this.price = price;
    }
//    public void infotow(){
//        System.out.println(" booknameYET： " + this.name + " priceYET: " + this.price);
//    }
    public void updatePrice(){
        if (this.price > 150){
            this.price = 150;
        }else if(this.price > 100){
            this.price = 100;
        }
    }

    public void info(){
        System.out.println(" bookname： " + this.name + " price: " + this.price);
    }
}
