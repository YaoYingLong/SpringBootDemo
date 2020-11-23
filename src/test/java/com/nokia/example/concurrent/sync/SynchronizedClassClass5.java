package com.nokia.example.concurrent.sync;

/**
 * @author by YingLong on 2020/10/20
 */
public class SynchronizedClassClass5 implements Runnable {
    @Override
    public void run() {
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("类锁同步代码块形式：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
    public static void main(String[] args) {
        SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
        SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();
        Thread thread1 = new Thread(instance1, "thread1");
        Thread thread2 = new Thread(instance2, "thread2");
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("finished");
    }
}
