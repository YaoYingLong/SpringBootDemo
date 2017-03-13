package com.nokia.example.Basics.Basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by YLongYao on 2016/10/26.
 */
public class EqualsIssueTest {
    @Test
    public void IntAndDoubleTest(){
        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;
//        assertEquals(true , (i == l));    出错
//        assertEquals(true , (i == d));    出错
//        assertEquals(true , (d == l));    出错
        assertEquals(false , i.equals(d));
        assertEquals(false , d.equals(l));
        assertEquals(false , i.equals(l));
        assertEquals(true , l.equals(42l));
    }
}
