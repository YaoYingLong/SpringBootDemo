package com.nokia.example.DesignPattern.AbstractFactory;

import com.nokia.example.DesignPattern.AbstractFactory.Human;

/**
 * @author by YingLong on 2020/11/3
 */
public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色人种");
    }

    @Override
    public void talk() {
        System.out.println("我是黑色人种");
    }
}
