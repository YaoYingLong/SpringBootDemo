package com.nokia.example.Basics.Basic;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class ArrayAndLinkedList {

    /**
     * 1、ArrayList是基于动态数组的数据结构，LinkedList是基于链表的数据结构
     * 2、对于随机访问get个set，ArrayList优于LinkedList，因为LinkedList需要移动指针
     * 3、对于新增删除操作add和remove，LinkedList有优势，因为ArrayList要移动数据
     * 4、若只对单条数据插入或删除，ArrayList的速度反而优于LinkedList
     * 5、但若是批量随机的插入删除数据，LinkedList的速度大大优于ArrayList.
     *      因为ArrayList每插入一条数据，要移动插入点及之后的所有数据
     */
    @Test
    public void ArrAndLinkTest(){
        LinkedList linkedList = new LinkedList();
        long time3 = new Date().getTime();
        for(int m=0;m<20000;m++){
            //当在200000条数据之前插入20000条数据时，LinkedList只用了1125多ms.这就是LinkedList的优势所在
            linkedList.add(m,null);
        }
        long time4 = new Date().getTime();
        System.out.print("batch linkedlist add:");
        System.out.println(time4 - time3);


        ArrayList arraylist = new ArrayList();
        for(int n=0;n<20000;n++){
            //当在20000条数据之前插入20000条数据时，ArrayList用了18375多ms.时间花费是arraylist的近20倍(视测试时机器性能)
            arraylist.add(n, null);
        }
        long time5 = new Date().getTime();
        System.out.print("batch arraylist add:");
        System.out.println(time5 - time4);
    }

    @Test
    public void ArrayAsListTest(){
        List<Integer> aList = Arrays.asList(1,2,3);
    }

}
