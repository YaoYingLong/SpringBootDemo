package com.nokia.example.Basics.ClassTest;

/**
 * Created by YLongYao on 2016/10/25.
 */
public class ContstructorTest {

    private class Contstructor1{
        /**
         * 构造器不能够被以下修饰词修饰
         * final、static、synchronized、native、void
         */
        public Contstructor1(){

        }
    }

    private class test1 extends Thread{

    }

    private class test2 extends Number{

        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public long longValue() {
            return 0;
        }

        @Override
        public float floatValue() {
            return 0;
        }

        @Override
        public double doubleValue() {
            return 0;
        }
    }

//    private class test3 extends Double{
//
//        public test3(double value) {
//            super(value);
//        }
//
//        public test3(String s) throws NumberFormatException {
//            super(s);
//        }
//    }

//    private class test4 extends Math{
//
//        /**
//         * Don't let anyone instantiate this class.
//         */
//        private test4() {
//        }
//    }

    private class test5 extends ClassLoader{

    }
}
