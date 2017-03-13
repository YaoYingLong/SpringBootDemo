package com.nokia.example.DesignPattern.Proxy;

/**
 * Created by YLongYao on 2016/10/31.
 */
public class Source implements Sourceable{

    @Override
    public void method() {
        System.out.println("the original method!");
    }

}
