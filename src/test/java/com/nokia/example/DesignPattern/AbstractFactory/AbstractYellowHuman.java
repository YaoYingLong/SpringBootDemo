package com.nokia.example.DesignPattern.AbstractFactory;

/**
 * @author by YingLong on 2020/11/3
 */
public abstract class AbstractYellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色人种");
    }

    @Override
    public void talk() {
        System.out.println("我是黄色人种");
    }
}
