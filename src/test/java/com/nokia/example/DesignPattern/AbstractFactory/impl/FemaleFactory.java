package com.nokia.example.DesignPattern.AbstractFactory.impl;

import com.nokia.example.DesignPattern.AbstractFactory.Human;
import com.nokia.example.DesignPattern.AbstractFactory.HumanFactory;

/**
 * @author by YingLong on 2020/11/3
 */
public class FemaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}
