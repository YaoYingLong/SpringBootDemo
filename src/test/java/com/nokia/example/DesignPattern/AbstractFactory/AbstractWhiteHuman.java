package com.nokia.example.DesignPattern.AbstractFactory;

import com.nokia.example.DesignPattern.AbstractFactory.Human;

/**
 * @author by YingLong on 2020/11/3
 */
public abstract class AbstractWhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色人种");
    }

    @Override
    public void talk() {
        System.out.println("我是白色人种");
    }
}
