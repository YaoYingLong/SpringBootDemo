package com.nokia.example.Basics.Interface;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/2.
 */
public class TestInterface {

    @Test
    public void TestInterface(){
        String[] args = new String[0];
        InterfaceA.main(args);
        InterfaceB.MethodK();
        String kk = InterfaceB.kk;
        System.out.println("kk=="+kk);
    }

}
