package com.nokia.example.DesignPattern.AbstractFactory.impl;

import com.nokia.example.DesignPattern.AbstractFactory.AbstractYellowHuman;

/**
 * @author by YingLong on 2020/11/3
 */
public class FemaleWhiteHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("白种女人");
    }
}
