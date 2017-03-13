package com.nokia.example.DesignPattern.Proxy;

import com.nokia.example.model.Person;
import org.junit.Test;

import java.lang.reflect.Proxy;
/**
 * Created by YLongYao on 2016/10/31.
 */
public class ProxyTest implements OriginProxy{

    @Override
    public void methodA(Person person){
        System.out.println("person:"+person.getName());
        System.out.println("This is methodA");
    }

    @Override
    public void methodB() {
        System.out.println("This is methodB");
    }

    @Test
    public void ProxyTest(){

        Person person = new Person();
        person.setId(1);
        person.setAddress("sss");
        person.setCity("cd");
        person.setName("kkkk");

        OriginProxy ak = (OriginProxy) Proxy.newProxyInstance(OriginProxy.class.getClassLoader(),
                new Class[]{OriginProxy.class},
                new ProxyFun(person));

        ak.methodA(person);
    }

}
