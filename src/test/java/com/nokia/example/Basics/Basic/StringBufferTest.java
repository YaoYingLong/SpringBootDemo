package com.nokia.example.Basics.Basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class StringBufferTest {
    /**
     * StringBuffer的默认容量是16
     * StringBuffer和StringBuilder功能相同，StringBuffer线程安全，StringBuilder非线程安全
     * StringBuffer是线程安全的StringBuilder
     */
    @Test
    public void StringBufferTest02(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1234");
        System.out.println("length=="+stringBuffer.length());
        System.out.println("length=="+stringBuffer.capacity());
    }

    @Test
    public void BreakTest01(){
        int i=0;
        for (;i<5;i++){
            if(i==2)
                break;
        }
        System.out.println("i=="+i);  //i==2
    }

    @Test
    public void BreakTest02(){
        /**
         * break只跳出第一层循环，而且跳出循环后j++将不会执行
         * 下列循环j将一直等于2
         */
        int i = 0 , j = 0;
        for (;i<5;i++){
            for (; j<5;j++) {
                if (j == 2 || j == 3)
                    break;
            }
            System.out.println("j="+j);
            System.out.println("i="+i);
        }
    }

    @Test
    public void StringBufferTest01(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<5;i++){
            list.add(i);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Integer num = (Integer)iterator.next();
            if(num.equals(2)){
                iterator.remove();
            }
        }
        System.out.println("size=="+list.size());
    }

}
