package com.nokia.example.Interview;

/**
 * @author by YingLong on 2020/9/16
 */
public class ThreadLocalIssue {

    static ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getId());

    public static void main(String[] args) throws InterruptedException {
        System.out.println(threadLocal.get());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(threadLocal.get())).start();
        }
        Thread.sleep(1000);
    }

}
