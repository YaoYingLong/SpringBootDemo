package com.nokia.example.Interview;

import com.nokia.example.Basics.Basic.StringTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by YLongYao on 2016/11/14.
 */
public class ReflectIssue {

    /**
     * 反射概念：
     *      主要指程序可以访问、检测和修改他本身状态和行为的一种能力
     *      程序在运行时能获取自身的信息
     *
     *
     * 反射的好处：
     *      使代码更灵活，更加容易实现面向对象
     *      能够使我们很方便的创建灵活的代码，这些代码可以在运行时再装配，无需组件之间进行源代码的链接
     *      体现了多态的应用，降低类之间的耦合性
     *      可以动态的创建对象和编译
     *
     * 反射的坏处：
     *      打破了Java的封装性，导致了Java对像的不安全
     *      使软件的性能降低，复杂度增加
     *
     * 哪些地方需要用到反射：
     *      Spring中很多地方就用到了反射，比如Java类解析XML和properties
     *
     *
     */

    //this is a reflect public paramenter
    public String reflectPara = "this is a reflect public parameter";
    //this is a reflect private parameter
    private String reflectPara1 = "this is a reflect private parameter";

    private void reflectPrivate(String str){
        System.out.println("private : " + str);
    }

    public void reflectPublic(String str){
        System.out.println("public : " + str);
    }

    @Test
    public void reflectTest(){
        try {
            Class clazz = Class.forName("com.nokia.example.Interview.ReflectIssue");
            Method method1 = clazz.getMethod("reflectPublic" , new Class[]{String.class});
            method1.invoke(clazz.newInstance() , new Object[]{"this is a public function"});

//            Method method2 = clazz.getMethod("reflectPrivate" , new Class[]{String.class});
//            method1.invoke(clazz.newInstance() , new Object[]{"this is a private function"});

            Method method3 = clazz.getDeclaredMethod("reflectPrivate" , new Class[]{String.class});
            method3.invoke(clazz.newInstance() , new Object[]{"this is a private function"});

            ((ReflectIssue)clazz.newInstance()).reflectPrivate("this is a private function");

            Field field = clazz.getField("reflectPara");
            System.out.println("field name:" + field.getName());
            System.out.println("field class:" + field.getDeclaringClass());
            System.out.println("field modifier:" + field.getModifiers());
            System.out.println("field value:" + field.get(clazz.newInstance()));
            field.set(clazz.newInstance() , "new val");
            System.out.println("field new value:" + field.get(clazz.newInstance()));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectMethodNameTest(){
        String className = "com.nokia.example.Basics.Basic.StringTest";
        try {
            Class clazz = Class.forName(className);
            Method method1 = clazz.getMethod("ClassOrMethodNameTest" , null);
            method1.invoke(clazz.newInstance() , new Object[0]);
            System.out.println("*****************************");
            ((StringTest)clazz.newInstance()).ClassOrMethodNameTest();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("方法名称:" + methodName);
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    System.out.println("参数名称:" + parameterName);
                }
                System.out.println("*****************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ClassLoaderTest(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println("class loader : " + classLoader.toString());

        classLoader.getParent();
    }

    @Test
    public void reflactTest(){
        String className = "com.nokia.example.Interview.ReflectIssue";
        try {
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("printString",  new Class[]{String.class,String.class});
            method.invoke(clazz.newInstance() , new Object[]{"this is a test","AAAAA"});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void printString(String str, String para){
        System.out.println("str:" + str + " : " + para);
    }

}
