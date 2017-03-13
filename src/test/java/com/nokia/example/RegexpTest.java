package com.nokia.example;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.Test;

/**
 * Created by YLongYao on 2016/8/24.
 */
public class RegexpTest {

    @Test
    public void regexp_test(){

        String regexStr = "[e][rbg]{2}[k]";
        String str = "erbk";
        boolean status = str.matches(regexStr);
        System.out.println("status===" + status);
    }
}
