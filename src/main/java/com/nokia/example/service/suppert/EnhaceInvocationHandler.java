package com.nokia.example.service.suppert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.Provider;

/**
 * Created by YLongYao on 2016/10/6.
 */
public class EnhaceInvocationHandler implements InvocationHandler{

    private Object service;

    public EnhaceInvocationHandler(Object service){
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
//        System.out.println("service===="+service.getClass());
//        System.out.println("proxy===="+proxy.getClass());
//        System.out.println("method===="+method.getClass());

        if (args != null){
            for (Object obj : args) {
//                System.out.println("args=="+obj.toString());
            }
        }else{
//            System.out.println("args==null");
        }

        try {
            result = method.invoke(service, args);
            if (result != null) {
//                System.err.println("Before invoke EnhaceInvocationHandler.");
            }else{
//                System.err.println("result is empty.");
            }
        } catch (Exception e) {
//            System.err.println("Error happen:");
            e.getCause().printStackTrace();
            throw e;
        }
        return result;
    }
}
