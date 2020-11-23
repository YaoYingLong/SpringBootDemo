package com.nokia.example.concurrent.sync;

/**
 * @author by YingLong on 2020/10/20
 */
public class SynchronizedMethod3 implements Runnable {

    @Override
    public void run() {
        this.method();
    }

    public synchronized void method() {
        System.out.println("方法锁：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        SynchronizedMethod3 instance = new SynchronizedMethod3();
        Thread thread1 = new Thread(instance, "thread1");
        Thread thread2 = new Thread(instance, "thread2");
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("finished");
    }
}
