package com.nokia.example.proxy.impl;

import com.nokia.example.proxy.Subject;

/**
 * @author by YingLong on 2020/9/10
 */
public class SubjectProxy implements Subject {

    private Subject subject;
    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doSomething(String param) {
        System.out.println("Do something before");
        subject.doSomething(param);
        System.out.println("Do something after");
    }
}
