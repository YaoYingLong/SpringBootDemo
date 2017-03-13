package com.nokia.example.Thread;

/**
 * Created by YLongYao on 2016/11/25.
 */
public class SleepT {
    /**
     * sleep() 的作用是让当前线程休眠，即当前线程会从“运行状态”进入到“休眠(阻塞)状态”
     * sleep()会指定休眠时间，线程休眠的时间会大于/等于该休眠时间；
     * 在线程重新被唤醒时，它会由“阻塞状态”变成“就绪状态”，从而等待cpu的调度执行。
     */
    private static class SleepTh extends Thread{
        public SleepTh(String name){
            super(name);
        }

        public synchronized void run(){
            try {
                for (int i = 0; i < 10; i++) {
//                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    System.out.println(this.getName() + " [" + this.getPriority() + "] : " + i);
                    if (i%4 == 0)
                        Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        Thread t1 = new SleepTh("t1");
        t1.start();
    }
}
