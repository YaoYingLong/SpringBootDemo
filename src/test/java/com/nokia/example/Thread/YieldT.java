package com.nokia.example.Thread;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/25.
 */
public class YieldT {
    /**
     * yield:
     *      yield()的作用是让步，它能让当前线程由“运行状态”进入“就绪状态”，
     *      从而让其他具有同等优先级的等待线程
     *      获取执行权，但是并不保证当前线程调用yield()后，其他具有相同优先级的线程就一定能获得执行权；
     *      也可能是当前线程又进入了“运行状态”继续执行
     *
     * yield余wait的区别：
     *      wait是让线程从“运行状态”到“等待（阻塞）状态”，而yield是让线程由“运行状态”进入到“就绪状态”
     *      wait会让线程释放其持有的对象同步锁，而yield不会释放同步锁
     */
    private class YieldTh extends Thread{
        public YieldTh(String name){
            super(name);
        }

        public synchronized void run(){
            for (int i = 0 ; i < 10 ; i++) {
//                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                System.out.println(this.getName()+" [" + this.getPriority()+ "] : " + i);
                if(i%4 == 0)
                    Thread.yield();
            }
        }
    }

    @Test
    public void YieldThTest(){
        YieldTh t1 = new YieldTh("t1");
        YieldTh t2 = new YieldTh("t2");
        t1.start();
        t2.start();
    }

    private Object obj = new Object();
    private class YieldTh1 extends Thread{
        public YieldTh1(String name){
            super(name);
        }

        public void run(){
            synchronized(obj){
                for (int i = 0 ; i < 10 ; i++) {
//                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    System.out.println(this.getName()+" [" + this.getPriority()+ "] : " + i);
                    if(i%4 == 0)
                        Thread.yield();
                }
            }
        }
    }

    @Test
    public void YieldTest(){
        Thread t1 = new YieldTh1("t1");
        Thread t2 = new YieldTh1("t2");
        t1.start();
        t2.start();
    }
}
