package com.nokia.example.Basics.ClassTest;

/**
 * Created by YLongYao on 2016/10/26.
 */
public class ThreadTest {
    /**
     * 多线程有两种实现方式：继承Thread类和实现Runnable接口
     * 有两种同步实现方法：同步方法和同步块
     */

    void waitForSignal(){
        Object obj = new Object();
        synchronized(Thread.currentThread()){
//            obj.wait();
            obj.notify();
        }
    }

    public static void main(String[] args){
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];
    }
}
