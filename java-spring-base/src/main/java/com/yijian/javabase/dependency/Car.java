package com.yijian.javabase.dependency;

/**
 * @author: yaojinhua
 * @date: 2021/5/6 14:18
 * @description:
 */
public class Car {

    /** 只包含基本数据类型的属性 */
    private int speed;

    private double price;

    public Car() {
    }

    public Car(int speed, double price) {
        this.speed = speed;
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", price=" + price +
                '}';
    }
}
