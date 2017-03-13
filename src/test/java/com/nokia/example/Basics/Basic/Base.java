package com.nokia.example.Basics.Basic;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/6.
 */
public class Base {
    /**
     * 标识符：
     *      任意顺序的大小写字母，数字、下划线(_)、美元符号($)
     *      且不能以数字开头，不能是Java关键字，不能是Java保留字
     */
    @Test
    public void shortTest(){

        float f = 124;
        int _poivt = 12;
        int $const = 23;
        int $k = 12;
        int kk = 23;

//      类型不兼容
        short s1 = 1 ;
//        s1 = s1 + 1;


        short s2 = 1 ;
        s2 += 1;
    }

    @Test
    public void charTest(){
        char c = '中';
    }

    @Test
    public void StringTest01(){
        String[] sArr = new String[10];
        System.out.println("sArr length : " + sArr.length);     //10
        System.out.println("sArr k : " + sArr[9]);              //null
        if(sArr[9] == null){
            System.out.println("is true");
        }
    }


}
