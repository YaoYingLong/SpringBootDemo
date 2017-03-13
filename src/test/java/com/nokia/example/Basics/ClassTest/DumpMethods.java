package com.nokia.example.Basics.ClassTest;

import java.lang.reflect.Method;

/**
 * Created by YLongYao on 2016/10/26.
 */
public class DumpMethods{


    public final void FinalTest(){

    }

    public final void FinalTest(String s){

    }

    public static void StaticTest(){

    }

    public static void StaticTest(String k){

    }

    public static void main(String[] args) {
        try {
            Class c=Class.forName(args[0]);
            Method m[]=c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}