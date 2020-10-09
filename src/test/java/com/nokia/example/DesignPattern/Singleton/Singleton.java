package com.nokia.example.DesignPattern.Singleton;

/**
 * Created by YLongYao on 2016/10/31.
 */
public class Singleton {

    private static volatile Singleton instance;

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){}

//    public static Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
