package com.nokia.example.DesignPattern.Singleton;

/**
 * Created by YLongYao on 2016/10/31.
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton(){

    }

    private Singleton getSingleton(){
        if(singleton == null)
            singleton = new Singleton();
        return singleton;
    }

}
