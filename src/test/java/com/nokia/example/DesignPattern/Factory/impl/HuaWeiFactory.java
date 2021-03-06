package com.nokia.example.DesignPattern.Factory.impl;

import com.nokia.example.DesignPattern.Factory.AbstractFactory;
import com.nokia.example.DesignPattern.Factory.PC;
import com.nokia.example.DesignPattern.Factory.Phone;

/**
 * @author by YingLong on 2020/10/23
 */
public class HuaWeiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new HwPhone();
    }

    @Override
    public PC makePC() {
        return new HwPC();
    }
}
