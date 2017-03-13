package com.nokia.example.Thread;

import org.junit.Test;

public class Thread01 {
    /**
     * 线程共有五种状态：
     *      新建状态：线程对象被创建后，就进入了新建状态；如：Thread thread = new Thread();
     *      就绪状态：也叫可执行状态，线程被创建后其他线程调用了该对象的start()方法，从而来启动该线程，
     *                处于就绪状态的线程随时可以被ＣＰＵ掉调度执行
     *      运行状态：线程获取CPU权限进行执行；注：线程只能从就绪状态进入到运行状态
     *      阻塞状态：线程因为某种原因放弃CPU使用权，暂时停止执行，直到线程进入就绪状态，才有机会转到运行状态
     *                阻塞的三种情况：
     *                    等待阻塞：通过调用线程的wait()方法，让线程等待某工作的完成
     *                    同步阻塞：线程在获得synchronized同步锁失败，它会进入同步阻塞状态
     *                    其他阻塞：通过调用线程的sleep()或join()或发出I/O请求时，线程进入阻塞状态，
     *                      当sleep()状态超时，join()等待线程终止或者超时，I/O处理完毕时，线程重新进入就绪状态
     *      死亡状态：线程执行完毕或者因异常退出了run()方法，该线程结束生命周期
     *
     * 注：
     *      Object类定义了wait()、notify()、notifyAll()等休眠唤醒函数
     *      Thread类定义了一些线程操作函数，如sleep()休眠函数、interrupt()中断函数、getName()获取线程名称
     *      synchronized关键字，分为synchronized代码块和synchronized方法，作用是让线程获取对象的同步锁
     *
     *Thread和Runnable不同点：
     *      Runnable是一个接口，只包含了一个run方法
     *      Thread是一个类，Thread本身就实现了Runnable接口
     *      Runnable具有更好的扩展性，Runnable还可以用于“资源的共享”，
     *          即：多线程都是基于一个Runnable对象创建的，他们会共享Runnable上的资源
     *      建议通过“Runnable”实现多线程
     *
     * start方法和run方法的区别：
     *      start()作用是启动一个线程，新线程会执行的相应的run()，start()不能被重复调用
     *      run()和普通的成员方法一样，可被重复调用，单独调用run()会在当前线程中执行run()，而不会启动新线程
     *
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
    private class TOne extends Thread{

        private int ticket = 10;
        public void run(){
            for (int i=0;i<20;i++){
                if (this.ticket > 0){
                    System.out.println(this.getName()+" : " + this.ticket--);
                }
            }
        }
    }
    @Test
    public void TOneTest(){
        TOne t1 = new TOne();
        TOne t2 = new TOne();
        TOne t3 = new TOne();
        t1.start();
        t2.start();
        t3.start();
//        t1.run();
//        t2.run();
//        t3.run();
    }

    public class TTwo implements Runnable{
        private int ticket  = 10;
        @Override
        public void run() {
            for (int i=0;i<20;i++){
                if (this.ticket > 0){
                    System.out.println(Thread.currentThread().getName()+" : " + this.ticket--);
                }
            }
        }
    }

    @Test
    public void TTwoTest(){
        TTwo tTwo = new TTwo();
        Thread t1 = new Thread(tTwo);
        Thread t2 = new Thread(tTwo);
        Thread t3 = new Thread(tTwo);
        t1.start();
        t2.start();
        t3.start();
//        t1.run();
//        t2.run();
//        t3.run();
    }

    public class TThree extends Thread{

        public TThree(String name){
            super(name);
        }

        public void run(){
            System.out.println(Thread.currentThread().getName() + " is running;");
        }
    }

    @Test
    public void TThreeTest(){
        TThree tThree = new TThree("TThree");

        System.out.println(Thread.currentThread().getName() + " : call thread run");
        tThree.run();

        System.out.println(Thread.currentThread().getName() + " : call thread start");
        tThree.start();
    }

    public class TFore implements Runnable{
        @Override
        public void run() {
            System.out.println(this.getClass().getName());
            synchronized (this){
                try{
                    for(int i = 0; i < 5; i++){
//                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+ " : " + i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("a interrupted exception throw");
                }
            }
        }
    }
    @Test
    public void TForeTest() throws InterruptedException {
        Runnable tFore = new TFore();

        Thread t1 = new Thread(tFore , "thread01");
        Thread t2 = new Thread(tFore , "thread02");
        t1.start();
        t2.start();

    }
    public static class TFive extends Thread{
        public TFive(String name){
            super(name);
        }
        public void run() {
            System.out.println(this.getClass().getName());
            synchronized (this){
                try{
                    for(int i = 0; i < 5; i++){
                        System.out.println(i);
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+ " : " + i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("a interrupted exception throw");
                }
            }
        }
    }

//    public static void main(String args[]){
//        Thread t1 = new TFive("thread01");
//        Thread t2 = new TFive("thread02");
//        t1.start();
//        t2.start();
//    }

    @Test
    public void TFiveTest(){
        /**
         * TFive中synchronized(this)中的this代表的是TFive
         * t1和t2是两个不同的TFive对象
         */
        Thread t1 = new TFive("thread01");
        Thread t2 = new TFive("thread02");
        t1.start();
        t2.start();
    }

    private class TSex{
        public void synMethod(){
            synchronized(this){
                for (int i=0 ; i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " syn method " + i);
                }
            }
        }

        public void nonSynMethod(){
            for (int i=0 ; i<10;i++){
                System.out.println(Thread.currentThread().getName() + " nonsyn method " + i);
            }
        }
    }

    @Test
    public void TSextTest(){
        final TSex tSex = new TSex();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                tSex.synMethod();
            }
        } , "t1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                tSex.nonSynMethod();
            }
        } , "t2");
        t1.start();
        t2.start();
    }

    private class TSeven{
        public void synMethod(){
            synchronized(this){
                for (int i=0 ; i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " syn method " + i);
                }
            }
        }

        public void nonSynMethod(){
            synchronized(this){
                for (int i=0 ; i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " nonsyn method " + i);
                }
            }
        }
    }

    @Test
    public void TSevenTest(){
        final TSeven tSeven = new TSeven();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                tSeven.synMethod();
            }
        } , "t1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                tSeven.nonSynMethod();
            }
        } , "t2");
        t1.start();
        t2.start();
    }

}
