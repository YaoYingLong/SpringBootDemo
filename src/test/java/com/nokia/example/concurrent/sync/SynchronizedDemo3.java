package com.nokia.example.concurrent.sync;

/**
 * @author by YingLong on 2020/10/20
 */
public class SynchronizedDemo3 {
    public void method() {
        synchronized (this) {
            System.out.println("Synchronized");
        }
    }
}
