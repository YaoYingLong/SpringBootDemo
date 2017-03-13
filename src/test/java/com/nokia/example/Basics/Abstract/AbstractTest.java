package com.nokia.example.Basics.Abstract;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/2.
 */
public class AbstractTest extends NotAbstract{
    
    @Test
    public void AbstractTest(){
        String[] args = new String[0];
        AbstractClassA.main(args);
        AbstractClassB.MethodK();
        System.out.println("AbstractClassB KK:"+AbstractClassB.kk);

        super.MethodD();

    }
     
}
