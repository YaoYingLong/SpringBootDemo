package com.nokia.example.DesignPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by YLongYao on 2016/10/31.
 */
public class ProxyFun implements InvocationHandler{

    private Object service;

    public ProxyFun(Object service){
        this.service = service;
    }
    /**
     * @param proxy     我们所代理的那个真实对象
     * @param method    指我们所要调用真实对象的某个方法的Method对象
     * @param args      指的是调用真实对象某个方法时接收的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("service===="+service.getClass());
        System.out.println("proxy===="+proxy.getClass());
        System.out.println("method===="+method.getClass());

        if (args != null){
            for (Object obj : args) {
                System.out.println("args=="+obj.toString());
            }
        }else{
            System.out.println("args==null");
        }

        try {
            System.out.println("service=="+service.toString());
            result = method.invoke(service , args);
            if (result != null) {
                System.err.println("Before invoke EnhaceInvocationHandler.");
            }else{
                System.err.println("result is empty.");
            }
        } catch (Exception e) {
            System.err.println("Error happen:");
            e.getCause().printStackTrace();
            throw e;
        }
        return result;
    }

}
