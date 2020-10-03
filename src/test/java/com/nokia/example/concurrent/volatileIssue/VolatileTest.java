package com.nokia.example.concurrent.volatileIssue;

import com.nokia.example.DesignPattern.Proxy.Source;
import groovy.util.ConfigObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by YingLong on 2020/10/3
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10000; i1++) {
                        increase();
                    }
                    System.out.println(Thread.currentThread().getId() + " completed");
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.activeCount());  //eclipse或java执行是1，idea执行是2
        Thread.currentThread().getThreadGroup().list(); // 打印当前线程组的线程

        System.out.println(race);
    }

    volatile boolean shutdownRequested;

    public void shutdown() {
        shutdownRequested = true;
    }

    public void doWork() {
        while (!shutdownRequested) {
            // do stuff
        }
    }

    Map configOptions;
    char[] configText;
    volatile boolean initialized = false;

    // 线程A中执行
    public void init(String fileName) {
        configOptions = new HashMap();
        configText = readConfigFile(fileName);
        processConfigOptions(configText, configOptions);
        initialized = true;
    }

    // 线程B中执行
    public void use() throws InterruptedException {
        while (!initialized) {
            Thread.sleep(10);
        }
        doSomethingWithConfig();
    }

    private void doSomethingWithConfig() {
    }

    private void processConfigOptions(char[] configText, Map configOptions) {

    }

    private char[] readConfigFile(String fileName) {
        return new char[0];
    }
}
