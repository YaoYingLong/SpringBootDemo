package com.nokia.example.DesignPattern.Proxy;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/31.
 */
public class Proxy implements Sourceable{

    private Source source;

    public Proxy(){
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }

    private void atfer() {
        System.out.println("after proxy!");
    }

    private void before() {
        System.out.println("before proxy!");
    }

    @Test
    public void ProxyTest(){
        Sourceable source = new Proxy();
        source.method();
    }

}
