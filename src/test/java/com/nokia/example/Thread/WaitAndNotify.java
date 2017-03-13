package com.nokia.example.Thread;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/25.
 */
public class WaitAndNotify {
    /**
     * Object中定义了wait、notify、notifyAll等接口，
     *      wait的作用是让当前线程进入等待状态，同时wait会让当前线程释放它持有的锁
     *      notify和notifyAll的作用是唤醒当前对象上等待的对象
     *      notify：唤醒此对象监视器上等待的单个线程
     *      notifyAll：唤醒此对象监视器上等待的所有线程
     *      wait：让当前线程处于“等待（阻塞）状态”直到其他线程调用该对象的notifyAll或notify，
     *            当前线程被唤醒（进入就绪状态）
     *      wait(long timeout)：同上，或者超过指定的时间量
     *      wait(long timeout , int nanos)：同上，或者其他线程中断当前线程
     */

    private class NotifyT extends Thread{
        public NotifyT(String name){
            super(name);
        }

        public void run(){
            synchronized (this) {
                System.out.println(Thread.currentThread().getName()+" call notify()");
                // 唤醒当前的wait线程
                notify();
            }
        }
    }

    @Test
    public void NotifyTest(){
        NotifyT t1 = new NotifyT("t1");

        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName()+" start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName()+" wait()");
                t1.wait();

                System.out.println(Thread.currentThread().getName()+" continue");
//            } catch (InterruptedException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+" continue end");
    }

    public class WaitT extends Thread{
        public WaitT(String name){
            super(name);
        }

        public void run(){
            System.out.println(Thread.currentThread().getName() + " run;");
            while(true);
        }
    }
    @Test
    public void WaitTest(){
        WaitT t1 = new WaitT("t1");

        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(3000);

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object object = new Object();

    public class ObjectSync extends Thread{
        public ObjectSync(String name){
            super(name);
        }

        public void run(){
            synchronized(object){
                try{
                    System.out.println(Thread.currentThread().getName() + " wait;");

                    object.wait();

                    System.out.println(Thread.currentThread().getName() + " continue;");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void ObjectSyncTest(){
        Thread t1 = new ObjectSync("t1");
        Thread t2 = new ObjectSync("t2");
        Thread t3 = new ObjectSync("t3");
        t1.start();
        t2.start();
        t3.start();

        try{
            System.out.println(Thread.currentThread().getName() + " sleep(1000)");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (object){
            System.out.println(Thread.currentThread().getName() + " notifyAll");
            object.notifyAll();
        }
    }
}
