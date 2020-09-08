package com.nokia.example.Interview;

import com.nokia.example.Basics.Basic.StringTest;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by YLongYao on 2016/11/14.
 */
public class ReflectIssue {

    /**
     * 反射概念：
     * 主要指程序可以访问、检测和修改他本身状态和行为的一种能力
     * 程序在运行时能获取自身的信息
     * <p>
     * <p>
     * 反射的好处：
     * 使代码更灵活，更加容易实现面向对象
     * 能够使我们很方便的创建灵活的代码，这些代码可以在运行时再装配，无需组件之间进行源代码的链接
     * 体现了多态的应用，降低类之间的耦合性
     * 可以动态的创建对象和编译
     * <p>
     * 反射的坏处：
     * 打破了Java的封装性，导致了Java对像的不安全
     * 使软件的性能降低，复杂度增加
     * <p>
     * 哪些地方需要用到反射：
     * Spring中很多地方就用到了反射，比如Java类解析XML和properties
     */

    //this is a reflect public paramenter
    public String publicParam = "this is a reflect public parameter";
    //this is a reflect private parameter
    private String privateParam = "this is a reflect private parameter";

    private void reflectPrivate(String str) {
        System.out.println("private : " + str);
    }

    public void reflectPublic(String str) {
        System.out.println("public : " + str);
    }

    public void moreParam(String paramA, String paramB) {
        System.out.println("paramA : " + paramA + ", paramB：" + paramB);
    }

    public ReflectIssue(String publicParam, String privateParam) {
        this.publicParam = publicParam;
        this.privateParam = privateParam;
    }

    public ReflectIssue() {
    }
}
