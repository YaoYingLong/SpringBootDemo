package com.nokia.example.concurrent.sync;

/**
 * @author by YingLong on 2020/10/20
 */
public class SynchronizedDemo6 implements Runnable {
    @Override
    public void run() {

    }

    public synchronized void method(int a) {
        System.out.println("a = " + a);
        if (a == 0) {
            method(a + 1);
        }
    }

    public synchronized void methodA() {
        System.out.println("methodA");
        methodB();
    }

    public synchronized void methodB() {
        System.out.println("methodB");
    }

    public static void main(String[] args) {
        SynchronizedDemo6 instance = new SynchronizedDemo6();
        instance.method(0);
        instance.methodA();
    }
}

class TestClass extends SynchronizedDemo6 {
    public synchronized void methodB() {
        System.out.println("subclass methodB");
        super.methodB();
    }
}
