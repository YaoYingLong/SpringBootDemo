package com.nokia.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author by YingLong on 2020/9/9
 */
public class EnhaceInvocationHandler implements InvocationHandler {

    private Object target;

    public EnhaceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("target====" + target.getClass());
        System.out.println("proxy====" + proxy.getClass());
        System.out.println("method====" + method.getClass());

        if (args != null) {
            for (Object obj : args) {
                System.out.println("args==" + obj.toString());
            }
        } else {
            System.out.println("args==null");
        }

        try {
            System.out.println("Do something before");
            Object result = method.invoke(target, args);
            System.out.println("Do something after");
            return result;
        } catch (Exception e) {
            e.getCause().printStackTrace();
            throw e;
        }
    }

    public Object creatProxyObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
