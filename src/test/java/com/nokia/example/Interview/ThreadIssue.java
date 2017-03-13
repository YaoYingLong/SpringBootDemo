package com.nokia.example.Interview;

import com.nokia.example.Entity.EnumT;
import org.apache.tomcat.jni.Thread;
import org.junit.Test;
import org.springframework.security.web.savedrequest.Enumerator;

import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by YLongYao on 2016/11/2.
 */
public class ThreadIssue {
    /**
     * 创建线程的3种方式：
     *      继承Thread类。
     *      实现Runnable接口。
     *      应用程序可以使用Executor创建线程池。
     *
     * 同步方法和同步代码块的区别：
     *      同步方法默认使用this或者当前类对象作为锁。
     *      同步代码块可以选择以什么来作为锁，可以选择发生同步问题的代码块而不是整个方法。
     *
     * 死锁：
     *      两个或两个以上的线程都在等待对方执行完毕才继续往下执行的时候。
     *
     * 如何避免死锁：
     *      指定各个线程的取锁顺序
     *
     * Java使用监视器实现了进程之间的异步执行
     *
     * 线程安全的集合有：
     *      Stack ， Vector ， HashTable ， Enumeration
     *
     */

    @Test
    public void CollectionTest(){
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.forEach(val -> {
            System.out.println("stack:" + val);
        });
        stack.isEmpty();
        stack.pop();
        stack.peek();

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);


    }

    private class ThreadTest extends Thread implements Runnable{

        @Override
        public void run() {
            System.out.println("this is a new thread.");

        }
    }

    @Test
    public void ThreadTest(){
//        Thread a = new Thread(new ThreadTest());
    }
}
