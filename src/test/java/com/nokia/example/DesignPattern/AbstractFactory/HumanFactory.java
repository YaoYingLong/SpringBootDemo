package com.nokia.example.DesignPattern.AbstractFactory;

/**
 * @author by YingLong on 2020/11/3
 */
public interface HumanFactory {
    Human createYellowHuman();

    Human createWhiteHuman();

    Human createBlackHuman();
}
