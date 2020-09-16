package com.nokia.example.concurrent;

/**
 * @author by YingLong on 2020/9/16
 */
public class Val<T> {

    T val;

    public T get() {
        return val;
    }

    public void set(T val) {
        this.val = val;
    }
}
