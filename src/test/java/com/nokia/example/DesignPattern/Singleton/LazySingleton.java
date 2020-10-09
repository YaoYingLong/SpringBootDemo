package com.nokia.example.DesignPattern.Singleton;

/**
 * @author by YingLong on 2020/10/9
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
