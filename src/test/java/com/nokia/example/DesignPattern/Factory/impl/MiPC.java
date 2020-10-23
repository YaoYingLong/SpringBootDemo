package com.nokia.example.DesignPattern.Factory.impl;

import com.nokia.example.DesignPattern.Factory.PC;

/**
 * @author by YingLong on 2020/10/23
 */
public class MiPC implements PC {
    @Override
    public void make() {
        System.out.println("Make XiaoMi PC!");
    }
}
