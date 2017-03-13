package com.nokia.example.Basics.DownCast;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/22.
 */
public class ExtendIssue {

    /**
     * 构造器不能够被继承因此不能被重写Override但是可以被重载
     */
    private class Base{
        public Base(){
            System.out.println("Base");
        }
    }

    private class ExtendBase extends Base{

    }

    @Test
    public void ExtecdIssueTest(){
        new ExtendIssue();
        new Base();
    }
}
