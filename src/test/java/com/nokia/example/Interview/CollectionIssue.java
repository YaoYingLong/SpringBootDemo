package com.nokia.example.Interview;

import org.junit.Test;

import java.util.*;

public class CollectionIssue {

    /**
     * List的实现类有：
     *      ArrayList：线程不安全，查询速度快
     *      LinkedList：链表结构，曾删速度快
     *      Vector：线程安全，但是速度慢
     *      Stack：继承自Vector
     *
     * Set的实现类：
     *      HashSet：
     *      TreeSet：
     *      LinkedHashSet:
     *
     *
     *  Map的实现类(非集合类)：
     *      HashMap
     *      LinkedHashMap
     *      TreeMap
     *      HashTable
     *      WeakHashMap
     */

    @Test
    public void ListTest(){
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Vector vector = new Vector();
        Stack stack = new Stack();
    }

    @Test
    public void SetTest(){
        HashSet hashSet = new HashSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        TreeSet treeSet = new TreeSet();
    }

    @Test
    public void QueueTest(){
        Queue queue = new PriorityQueue();
    }



}
