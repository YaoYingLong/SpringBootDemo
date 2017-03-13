package com.nokia.example.Basics.ClassTest;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/26.
 */
public class ExceptionTest {

    //最终只打印12，如果不在catch中抛出异常则打印123

    @Test
    public void ExceptionTest(){
        try{
            int i = 100 / 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            throw new RuntimeException();
        }finally{
            System.out.print(2);
        }
        System.out.print(3);
    }
}
