package com.nokia.example.Basics.ClassTest;

import org.junit.Test;

public class ClassTest2 {

    private String baseName = "base";

    public ClassTest2(){
        callName();
    }

    public void callName(){
        System.out.println("base:" + baseName);
    }

    static class Sub extends ClassTest2{

        private String baseName = "sub";

        public void callName(){
            System.out.println ("sub:"+baseName) ;
        }
    }

    public static void main(String[] args){
        ClassTest2 sub = new Sub();
        System.out.println("-----------------");
        //sub.callName();
    }

}
