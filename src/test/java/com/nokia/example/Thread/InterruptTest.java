package com.nokia.example.Thread;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/25.
 */
public class InterruptTest {
    /**
     * interrupt()的作用是中断本线程，其它线程调用本线程的interrupt()方法时，
     * 会通过checkAccess()检查权限。这有可能抛出SecurityException异常。
     * 若线程在阻塞状态时，调用了它的interrupt()方法，那么它的“中断状态”
     * 会被清除并且会收到一个InterruptedException异常。
     * <p>
     * Thread中的stop()和suspend()方法，由于固有的不安全性，已经建议不再使用
     */

    public static class InterT extends Thread {
        public InterT(String name) {
            super(name);
        }

        public void run() {
            try {
                int i = 0;
                while (!isInterrupted()) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i++);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptException ");
            }
        }
    }

    @Test
    public void InterTest() {
        try {
            Thread t1 = new InterT("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            Thread.sleep(3000);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            Thread.sleep(3000);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        public void run() {
            int i = 0;
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100); // 休眠100ms
                } catch (InterruptedException ie) {
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
                }
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
            }
        }
    }

    @Test
    public void MyThreadTest() {
        try {
            Thread t1 = new MyThread("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            Thread.sleep(3000);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            Thread.sleep(3000);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
