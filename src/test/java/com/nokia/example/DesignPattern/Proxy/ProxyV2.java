package com.nokia.example.DesignPattern.Proxy;

/**
 * @author by YingLong on 2020/11/5
 */
public class ProxyV2 implements Subject {
    private Subject subject;
    public ProxyV2(Subject subject) {
        this.subject = subject;
    }
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }
    private void before() {}
    private void after() {}
}
