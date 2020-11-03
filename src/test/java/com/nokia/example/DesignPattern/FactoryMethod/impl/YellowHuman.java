package com.nokia.example.DesignPattern.FactoryMethod.impl;

import com.nokia.example.DesignPattern.FactoryMethod.Human;

/**
 * @author by YingLong on 2020/11/3
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色人种");
    }

    @Override
    public void talk() {
        System.out.println("我是黄色人种");
    }
}
