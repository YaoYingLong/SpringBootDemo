package com.nokia.example.DesignPattern.FactoryMethod.impl;

import com.nokia.example.DesignPattern.FactoryMethod.Human;

/**
 * @author by YingLong on 2020/11/3
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色人种");
    }

    @Override
    public void talk() {
        System.out.println("我是白色人种");
    }
}
