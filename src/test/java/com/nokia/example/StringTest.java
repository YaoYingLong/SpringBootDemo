package com.nokia.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author by YingLong on 2020/10/12
 */
public class StringTest {

    @Test
    public void baseTest() {
        String s1 = new StringBuilder("go").append("od").toString();
        assertTrue(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        assertFalse(s2.intern() == s2);
        String s3 = new StringBuilder("aa").append("bb").toString();
        assertTrue(s3.intern() == s3);
    }

}
