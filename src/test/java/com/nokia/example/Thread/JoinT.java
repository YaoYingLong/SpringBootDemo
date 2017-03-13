package com.nokia.example.Thread;

/**
 * Created by YLongYao on 2016/11/25.
 */
public class JoinT {
    /**
     * 让“主线程”等待“子线程”结束之后才能继续运行
     */
    static class ThreadA extends Thread{

        public ThreadA(String name){
            super(name);
        }
        public void run(){
            System.out.printf("%s start\n", this.getName());

            // 延时操作
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s finish\n", this.getName());


        }
    }

    public static void main(String[] args){
        try {
            ThreadA t1 = new ThreadA("t1"); // 新建“线程t1”

            t1.start();                     // 启动“线程t1”
            // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            t1.join();

            System.out.printf("%s finish\n", Thread.currentThread().getName());
//        } catch (Exception e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
