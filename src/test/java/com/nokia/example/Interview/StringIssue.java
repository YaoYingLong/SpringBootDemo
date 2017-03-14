package com.nokia.example.Interview;

import org.junit.Test;

public class StringIssue {

    /**
     *  String:
     *      创建的是不可变的对象，每当用String操纵字符串时，实际上是在不断的创建新的对象，而原来的对象就会
     *      变为垃圾被GC回收掉，故执行效率最低
     *
     *  StringBuffer:
     *      创建的是字符串变量，每当我们对字符串操作时，实际上是在一个对象像操作，线程安全
     *
     *  StringBuilder:
     *      创建的是字符串变量，每当我们对字符串操作时，实际上是在一个对象像操作，非线程安全
     *
     *  执行速度比较：
     *      String  <  StringBuffer  <  StringBuilder
     *
     *  如果操纵少量数据用：String
     *  单线程操纵字符缓冲区下大量数据使用：StringBuilder
     *  多线程操纵字符缓冲区下大量数据使用：StringBuffer
     */


    public static String BASEINFO = "Mr.Y";
    public static final int COUNT = 2000000;

    @Test
    public void StringTest(){
        String str = new String(BASEINFO);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < COUNT / 100; i++) {
            str = str + "miss";
        }
        long endtime = System.currentTimeMillis();
        //1450 millis
        System.out.println((endtime - starttime) + " millis has costed when used String.");
    }

    @Test
    public void StringBufferTest(){
        StringBuffer sb = new StringBuffer(BASEINFO);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            sb = sb.append("miss");
        }
        long endtime = System.currentTimeMillis();
        //76 millis
        System.out.println((endtime - starttime) + " millis has costed when used StringBuffer.");
    }

    @Test
    public void StringBuilderTest(){
        StringBuilder sb = new StringBuilder(BASEINFO);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            sb = sb.append("miss");
        }
        long endtime = System.currentTimeMillis();
        //40 millis
        System.out.println((endtime - starttime) + " millis has costed when used StringBuilder.");
    }

    @Test
    public void StringTest01(){
        String t1 = "hello";
        String t2 = "hel" + "lo";
        System.out.println("t1==t2 is " + (t1==t2));  //true

        System.out.println("5" + 2);        //52
    }

}
