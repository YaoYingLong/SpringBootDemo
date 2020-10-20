package com.nokia.example.concurrent.sync;

import sun.security.provider.certpath.SunCertPathBuilder;

/**
 * @author by YingLong on 2020/10/20
 */
public class SynchronizedDemo2 implements Runnable {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("I am lock1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1部分运行结束");
        }
        synchronized (lock2) {
            System.out.println("I am lock2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2部分运行结束");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo2 instance = new SynchronizedDemo2();
        Thread thread1 = new Thread(instance, "thread1");
        Thread thread2 = new Thread(instance, "thread2");
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
    }
}
