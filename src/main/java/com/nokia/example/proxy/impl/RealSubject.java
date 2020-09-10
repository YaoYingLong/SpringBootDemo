package com.nokia.example.proxy.impl;

import com.nokia.example.proxy.Subject;

/**
 * @author by YingLong on 2020/9/9
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething(String param) {
        System.out.println("RealSubject do something " + param);
    }
}
