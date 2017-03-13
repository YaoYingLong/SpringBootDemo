package com.nokia.example.Basics.ClassTest;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/26.
 */
public class ReturnTest {

    private int beforeAdd(int b){
        return ++b;
    }

    private int afterAdd(int b){
        return b++;
    }

    @Test
    public void ReturnTest(){
        int k = 100;
        System.out.println("bk == " + beforeAdd(k));    //101
        System.out.println("ak == " + afterAdd(k));     //100
    }

}
