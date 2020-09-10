package com.nokia.UT;

import com.nokia.example.proxy.CGLibProxy;
import com.nokia.example.proxy.EnhaceInvocationHandler;
import com.nokia.example.proxy.Subject;
import com.nokia.example.proxy.impl.RealSubject;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author by YingLong on 2020/9/9
 */
public class ProxyTest {

    public static void main(String[] args) {
        {
            Subject realSubject = new RealSubject();
//            Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
//                    new Class[]{Subject.class},
//                    new EnhaceInvocationHandler(realSubject));
//            subject.doSomething("AAAA");

            EnhaceInvocationHandler handler = new EnhaceInvocationHandler(realSubject);
            Subject subject = (Subject)  handler.creatProxyObj();
            subject.doSomething("AAAA");
        }
        System.out.println("-----------------------华丽的分割线---------------------");
        {
            Subject realSubject = new RealSubject();
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(realSubject.getClass());
//
//            enhancer.setCallback(new CGLibProxy());
//            Subject subject = (Subject) enhancer.create();
//            subject.doSomething("AAAA");

            CGLibProxy proxy = new CGLibProxy();
            Subject subject = (Subject) proxy.creatProxyObj(realSubject.getClass());
            subject.doSomething("AAAA");
        }
    }

}
