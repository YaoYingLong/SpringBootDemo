package com.nokia.example.DesignPattern.Singleton;

/**
 * Created by YLongYao on 2016/10/31.
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton.getSingleton();
    }

}
