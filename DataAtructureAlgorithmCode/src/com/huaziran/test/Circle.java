package com.huaziran.test;

public class Circle {

    public static void main(String[] args) {
        Circle2 c = new Circle2();
        Circle3 circle3 = new Circle3();
              circle3.printAreas(c, 5);
    }
}

class Circle2{
    double radius;
    public Circle2(){

    };
    public Circle2(double radius){
        this.radius = radius;
    }

    public double findRadius() {
        return Math.PI * radius*radius;
    }
    //修改圆的半径
    public void setRadius(double radius){
        this.radius = radius;
    }

}
class Circle3{
    public void printAreas(Circle2 c,int times){
        for (int i = 1 ;i < times ; i++){
            c.setRadius(i);
            System.out.println((double) i + "\t" + c.findRadius());
        }
    }
}
