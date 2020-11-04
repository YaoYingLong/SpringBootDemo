package com.nokia.example.DesignPattern.Builder;

/**
 * @author by YingLong on 2020/11/4
 */
public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("BMW开动");
    }
    @Override
    protected void stop() {
        System.out.println("BMW停车");
    }
    @Override
    protected void alarm() {
        System.out.println("BMW鸣笛");
    }
    @Override
    protected void engineBoom() {
        System.out.println("BMW发动引擎");
    }
}
