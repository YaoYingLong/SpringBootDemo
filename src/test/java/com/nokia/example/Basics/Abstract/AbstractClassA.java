package com.nokia.example.Basics.Abstract;

/**
 * Created by YLongYao on 2016/11/2.
 */
public abstract class AbstractClassA {

    public String para = "this is a parameter.";

    protected abstract void MethodA();

//    private abstract void MethodB();

    abstract void MethodC();

    public abstract void MethodD();

    public void MethodF(){
        System.out.println("Method f");
    }

    public static void main(String args[]){
        System.out.println("this is a abstract function.");
    }

}
