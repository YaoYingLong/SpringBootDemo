package com.nokia.example.concurrent.threadLocal;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by YingLong on 2020/9/16
 */
public class MyThreadLocal<T> {

    T value;

    static AtomicInteger atomic = new AtomicInteger();

    private int threadLocalHash = atomic.addAndGet(0x61c88647);

    static HashMap<Thread, HashMap<Integer, Object>> threadLocalHashMap = new HashMap<>();

    synchronized static HashMap<Integer, Object> getMap() {
        Thread thread = Thread.currentThread();
        if (!threadLocalHashMap.containsKey(thread)) {
            threadLocalHashMap.put(thread, new HashMap<>());
        }
        return threadLocalHashMap.get(thread);
    }


    protected T initialValue() {
        return null;
    }

    public T get() {
        HashMap<Integer, Object> map = getMap ();
        if (!map.containsKey(this.threadLocalHash)) {
            map.put(this.threadLocalHash, initialValue());
        }
        return (T) map.get(this.threadLocalHash);
    }

    public void set(T value) {
        HashMap<Integer, Object> map = getMap ();
        map.put(this.threadLocalHash, value);
    }

}
