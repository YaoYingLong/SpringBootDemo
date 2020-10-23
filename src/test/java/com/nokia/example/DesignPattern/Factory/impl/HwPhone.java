package com.nokia.example.DesignPattern.Factory.impl;

import com.nokia.example.DesignPattern.Factory.Phone;

/**
 * @author by YingLong on 2020/10/23
 */
public class HwPhone implements Phone {
    @Override
    public void make() {
        System.out.println("Make HuaWei phone!");
    }
}
