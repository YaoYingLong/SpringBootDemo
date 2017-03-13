package com.nokia.example;

import org.junit.Test;

import java.awt.print.PrinterGraphics;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

/**
 * Created by YLongYao on 2016/8/25.
 */
public class StringUtils {

    @Test
    public void StringLengthTest(){
        String str = "kkk";
        System.out.println("returnStr==" + str.length());
    }

    @Test
    public void UnicodeTest() throws UnsupportedEncodingException {
        String str = "2";
        byte[] returnStr = str.getBytes("Unicode");
        assertEquals(4 , returnStr.length);
        System.out.println("returnStr==" + returnStr.length);
    }
}
