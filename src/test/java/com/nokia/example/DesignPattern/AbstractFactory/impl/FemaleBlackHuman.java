package com.nokia.example.DesignPattern.AbstractFactory.impl;

import com.nokia.example.DesignPattern.AbstractFactory.AbstractYellowHuman;

/**
 * @author by YingLong on 2020/11/3
 */
public class FemaleBlackHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黑种女人");
    }
}
