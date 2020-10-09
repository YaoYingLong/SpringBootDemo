package com.nokia.example.DesignPattern.Singleton;

/**
 * @author by YingLong on 2020/10/9
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    private static HungrySingleton getInstance() {
        return instance;
    }
}
