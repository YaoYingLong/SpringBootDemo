package com.nokia.example.concurrent.threadLocal;

import org.slf4j.MDC;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by YingLong on 2020/9/13
 */
public class ThreadLocalIssue {

//    static MyThreadLocal<Long> threadLocal = new MyThreadLocal<Long>(){
//        @Override
//        protected Long initialValue() {
//            return Thread.currentThread().getId();
//        }
//    };

//    static HashMap<Thread, Val<Integer>> map = new HashMap<>();
    static HashSet<Val<Integer>> set = new HashSet<>();

    synchronized static void addSet(Val<Integer> val) {
        set.add(val);
    }

    static ThreadLocal<Val<Integer>> c = new ThreadLocal<Val<Integer>>(){
        @Override
        protected Val<Integer> initialValue() {
            Val<Integer> v = new Val<Integer>();
            v.set(0);
            addSet(v);
            return v;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executor.submit(new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Val<Integer> v = c.get();
                v.set(v.get() + 1);
            }));
        }
        MDC.get("kk");
        Thread.sleep(11000);
        System.out.println(set.stream().map(Val::get).reduce((a, sum) -> a + sum).get());
        for (Val<Integer> integerVal : set) {
            System.out.println(integerVal.get());
        }
        executor.shutdownNow();
    }

}
