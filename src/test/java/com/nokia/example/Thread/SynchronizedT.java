package com.nokia.example.Thread;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/25.
 */
public class SynchronizedT {
    /**
     * synchronized原理：
     *      每一个对象有且仅有一个同步锁对象，同步锁是依赖于对象而存在的
     *      我们调用某对象的synchronized方法就是获取了该对象的同步锁；不同线程对同步锁的访问是互斥的
     *      例如synchronized(obj)就是获取了obj这个对象的同步锁
     *
     * synchronized基本原则
     *      当一个线程访问某对象的synchronized方法或代码块时，
     *              其他线程对该对象的该synchronized方法或代码块的访问阻塞
     *              其他线程任然可以访问该对象的非同步代码块
     *              其他线程对该对象的其他synchronized方法或代码块的访问别阻塞
     *
     * 实例锁全局锁：
     *      实例锁：锁在某个对象上，实例锁对应的是synchronized关键字
     *      全局锁：针对的是类，无论实例多少个对象，线程都共享该锁，对应的是static synchronized
     */

    /**
     * 01不能被同时访问，因为访问的是同一个对象
     */
    @Test
    public void syncTest01(){
        Something x = new Something();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isSyncA();
            }
        } , "t1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isSyncB();
            }
        } , "t2");
        t1.start();
        t2.start();
    }

    /**
     * 02可以被同时访问，访问的不是同一个对象
     */
    @Test
    public void syncTest02(){
        Something x = new Something();
        Something y = new Something();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isSyncA();
            }
        } , "t1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                y.isSyncB();
            }
        } , "t2");
        t1.start();
        t2.start();
    }

    /**
     * 03不能被同时访问 ，访问的是同一个对象
     */
    @Test
    public void syncTest03(){
        Something x = new Something();
        Something y = new Something();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.cSyncA();
            }
        } , "t1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                y.cSyncB();
            }
        } , "t2");
        t1.start();
        t2.start();
    }

    /**
     * 04可以被同时访问 ，访问的不是同一个对象
     */
    @Test
    public void syncTest04(){
        Something x = new Something();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isSyncA();
            }
        } , "t1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.cSyncB();
            }
        } , "t2");
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                Something.cSyncB();
            }
        } , "t3");
        t1.start();
        t2.start();
        t3.start();
    }

    public static class Something{
        public synchronized void isSyncA(){
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+ " : " + i);
            }
        }
        public synchronized void isSyncB(){
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+ " : " + i);
            }
        }
        public static synchronized void cSyncA(){
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+ " : " + i);
            }
        }
        public static synchronized void cSyncB(){
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+ " : " + i);
            }
        }
    }
}