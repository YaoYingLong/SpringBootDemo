package com.nokia.example.concurrent.sync;

/**
 * @author by YingLong on 2020/10/20
 */
public class SynchronizedClassStatic4 implements Runnable {

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("静态方法锁：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
        SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();
        Thread thread1 = new Thread(instance1, "thread1");
        Thread thread2 = new Thread(instance2, "thread2");
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("finished");
    }
}
