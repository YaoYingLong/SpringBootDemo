package com.nokia.example.DesignPattern.FactoryMethod;

/**
 * @author by YingLong on 2020/11/3
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);

}
