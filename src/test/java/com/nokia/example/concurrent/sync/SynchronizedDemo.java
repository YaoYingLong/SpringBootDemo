package com.nokia.example.concurrent.sync;

/**
 * @author by YingLong on 2020/10/12
 */
public class SynchronizedDemo {

    public synchronized void sync1() {
        System.out.println("sync1");
    }

    public static synchronized void sync2() {
        System.out.println("sync2");
    }

    public void method() {
        synchronized (this) {
            System.out.println("sync method this");
        }
        synchronized (SynchronizedDemo.class) {
            System.out.println("sync method class");
        }
        String lock = "";
        synchronized (lock) {
            System.out.println("sync method lock");
        }
    }


    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.sync1();
    }

}
