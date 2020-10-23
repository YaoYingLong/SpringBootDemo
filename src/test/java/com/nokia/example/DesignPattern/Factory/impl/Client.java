package com.nokia.example.DesignPattern.Factory.impl;

import com.nokia.example.DesignPattern.Factory.AbstractFactory;
import com.nokia.example.DesignPattern.Factory.PC;
import com.nokia.example.DesignPattern.Factory.Phone;

/**
 * @author by YingLong on 2020/10/23
 */
public class Client {

    public void testProductFactory() {
        PhoneFactory factory = new PhoneFactory();
        Phone product = factory.makePhone("XiaoMi");
        product.make();
    }

    public void testAbstractFactory() {
        AbstractFactory factoryA = new XiaoMiFactory();
        factoryA.makePhone();
        AbstractFactory factoryB = new HuaWeiFactory();
        factoryB.makePhone();
    }


    public void testFactory() {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory huaWeiFactory = new HuaWeiFactory();
        Phone miPhone = miFactory.makePhone();
        PC miPC = miFactory.makePC();
        Phone huaWeiPhone = huaWeiFactory.makePhone();
        PC huaWeiPC = huaWeiFactory.makePC();
    }


}
