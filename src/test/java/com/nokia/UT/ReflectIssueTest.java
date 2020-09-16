package com.nokia.UT;

import com.nokia.example.Basics.Basic.StringTest;
import com.nokia.example.Interview.ReflectIssue;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author by YingLong on 2020/9/8
 */
public class ReflectIssueTest {

    public static void main(String[] args) throws Throwable {
        ReflectIssueTest test = new ReflectIssueTest();
        test.test();
    }

    public void test() throws Throwable {
        Class clazz = Class.forName("com.nokia.example.Interview.ReflectIssue");
//        Class clazz = "com.nokia.example.Interview.ReflectIssue".getClass();
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        Class clazz = classLoader.loadClass("com.nokia.example.Interview.ReflectIssue");
        System.out.println(clazz.getName());
        ReflectIssue reflectIssue = (ReflectIssue) clazz.newInstance();
        Field publicParam = clazz.getField("publicParam");
        System.out.println(publicParam.getName());
        System.out.println(publicParam.get(reflectIssue));


        Field privateParam = clazz.getDeclaredField("privateParam");
        privateParam.setAccessible(true);
        System.out.println(privateParam.getName());
        System.out.println(privateParam.get(reflectIssue));
        privateParam.set(reflectIssue, "new private param value");
        System.out.println(privateParam.getName());
        System.out.println(privateParam.get(reflectIssue));
        {
            Constructor constructor = clazz.getConstructor(String.class, String.class);
            ReflectIssue reflectIssue2 = (ReflectIssue) constructor.newInstance("paramA", "paramB");
            System.out.println(reflectIssue2.publicParam);
            Field privateParam2 = clazz.getDeclaredField("privateParam");
            privateParam2.setAccessible(true);
            System.out.println(privateParam2.getName());
            System.out.println(privateParam2.get(reflectIssue2));
        }
        {
            Constructor constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            ReflectIssue reflectIssue2 = (ReflectIssue) constructor.newInstance("paramA");
            System.out.println("Private constructor : " + reflectIssue2.publicParam);
        }

        {
            MethodType methodType = MethodType.methodType(void.class, String.class);
            MethodHandle methodHandle = MethodHandles.lookup().findVirtual(clazz, "reflectPublic", methodType).bindTo(clazz.newInstance());
            methodHandle.invokeExact("a");
        }
        {
            MethodType methodType = MethodType.methodType(void.class, String.class, String.class);
            MethodHandle methodHandle = MethodHandles.lookup().findVirtual(clazz, "moreParam", methodType).bindTo(clazz.newInstance());
            methodHandle.invokeExact("a", "b");
        }
        {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            Method pm = clazz.getDeclaredMethod("reflectPrivate", String.class);
            pm.setAccessible(true);

            MethodHandle methodHandle = lookup.unreflect(pm);
            methodHandle.invoke(clazz.newInstance(), "a");
            methodHandle.invokeExact((ReflectIssue) clazz.newInstance(), "a");
        }

        System.out.println("------------------------");

        {
            Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
            MethodType methodType = MethodType.methodType(void.class, String.class);
            MethodHandle methodHandle = MethodHandles.lookup().findVirtual(obj.getClass(), "println", methodType).bindTo(obj);
            methodHandle.invokeExact("lkkkk");
        }
    }


    @Test
    public void reflectTestBefore() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("com.nokia.example.Interview.ReflectIssue");
//        Class clazz = "com.nokia.example.Interview.ReflectIssue".getClass();
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        Class clazz = classLoader.loadClass("com.nokia.example.Interview.ReflectIssue");
        System.out.println(clazz.getName());
        ReflectIssue reflectIssue = (ReflectIssue) clazz.newInstance();
        Field publicParam = clazz.getField("publicParam");
        System.out.println(publicParam.getName());
        System.out.println(publicParam.get(reflectIssue));


        Field privateParam = clazz.getDeclaredField("privateParam");
        System.out.println(privateParam.getName());
        System.out.println(privateParam.get(reflectIssue));
        privateParam.setAccessible(false);
        privateParam.set(reflectIssue, "new private param value");
        System.out.println(privateParam.getName());
        System.out.println(privateParam.get(reflectIssue));

        Constructor constructor = clazz.getDeclaredConstructor(String.class, String.class);
        ReflectIssue reflectIssue2 = (ReflectIssue) constructor.newInstance("paramA", "paramB");
        System.out.println(reflectIssue2.publicParam);
        Field privateParam2 = clazz.getDeclaredField("privateParam");
        System.out.println(privateParam2.getName());
        System.out.println(privateParam2.get(reflectIssue2));
    }

    @Test
    public void reflectTest() {
        try {
            Class clazz = Class.forName("com.nokia.example.Interview.ReflectIssue");
            Method reflectPublic = clazz.getMethod("reflectPublic", String.class);
            reflectPublic.invoke(clazz.newInstance(), "this is a public function");

//            Method method2 = clazz.getMethod("reflectPrivate" , new Class[]{String.class});
//            method1.invoke(clazz.newInstance() , new Object[]{"this is a private function"});


            Method reflectPrivate = clazz.getDeclaredMethod("reflectPrivate", String.class);
            reflectPrivate.setAccessible(true);
            reflectPrivate.invoke(clazz.newInstance(), "this is a private function");

            ((ReflectIssue) clazz.newInstance()).reflectPublic("this is a public function");

            Field field = clazz.getField("reflectPara");
            System.out.println("field name:" + field.getName());
            System.out.println("field class:" + field.getDeclaringClass());
            System.out.println("field modifier:" + field.getModifiers());
            System.out.println("field value:" + field.get(clazz.newInstance()));
            field.set(clazz.newInstance(), "new val");
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
    public void reflectMethodNameTest() {
        String className = "com.nokia.example.Basics.Basic.StringTest";
        try {
            Class clazz = Class.forName(className);
            System.out.println("toGenericString:" + clazz.toGenericString());
            System.out.println("**************toGenericString***************");
            Method method1 = clazz.getMethod("ClassOrMethodNameTest", null);
            method1.invoke(clazz.newInstance(), new Object[0]);
            System.out.println("*****************************");
            ((StringTest) clazz.newInstance()).ClassOrMethodNameTest();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("方法名称:" + methodName);
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    System.out.println("参数名称:" + parameterName);
                    System.out.println("参数名称:" + clas.getTypeName());
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
    public void ClassLoaderTest() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println("class loader : " + classLoader.toString());

        classLoader.getParent();
    }

    @Test
    public void reflactTest() {
        String className = "com.nokia.example.Interview.ReflectIssue";
        try {
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("printString", new Class[]{String.class, String.class});
            method.invoke(clazz.newInstance(), new Object[]{"this is a test", "AAAAA"});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void printString(String str, String para) {
        System.out.println("str:" + str + " : " + para);
    }

    static class ClassA {
        public void println(String string) {
            System.out.println(string);
        }
    }

}
