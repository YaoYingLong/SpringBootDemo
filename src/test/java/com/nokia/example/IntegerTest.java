package com.nokia.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author by YingLong on 2020/10/12
 */
public class IntegerTest {

    /**
     * a b 与 c比较时会自动拆箱成基本类型再进行比较
     *
     * 装箱的本质是什么呢？ 当我们给一个 Integer 对象赋
     * 一个 int 值的时候， 会调用 Integer 类的静态方法 valueOf
     */
    @Test
    public void unboxingTest() {
        Integer a = new Integer(10);
        Integer b = 10;
        int c = 10;
        Integer d = 10;
        assertFalse(a == b);
        assertTrue(a == c);
        assertTrue(b == c);
        assertTrue(b == d);

        {
            Integer e = 127;
            Integer f = 127;
            assertTrue(e == f);
        }
        {
            Integer e = -128;
            Integer f = -128;
            assertTrue(e == f);
        }
        {
            Integer e = 128;
            Integer f = 128;
            assertFalse(e == f);
        }
        {
            Integer e = -129;
            Integer f = -129;
            assertFalse(e == f);
        }
        Integer g = Integer.valueOf(12);
    }

}
