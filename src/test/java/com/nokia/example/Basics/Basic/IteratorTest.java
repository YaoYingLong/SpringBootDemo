package com.nokia.example.Basics.Basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class IteratorTest {

    @Test
    public void IteratorListTest(){
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("kkk");
        list.add("ggg");
        Iterator it = list.iterator();
        int index = 0;
        while (it.hasNext()){
            Object obj = it.next();
            if (obj.equals("kkk")){
                it.remove();
                //list.remove(obj);  对导致循环出错，remove导致循环的长度变化了。
                //list.remove(index);
            }
            index ++;
        }
        System.out.println("list=="+list);
    }

}
