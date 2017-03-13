package com.nokia.example.Basics.Basic;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class ByteAndShort {

    public void add(Byte b){
        b = b++;
    }

    @Test
    public void test(){
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + " ");  //-128
        add(++b);
        add(++b);
        System.out.println(b + " ");  //-127
    }

}
