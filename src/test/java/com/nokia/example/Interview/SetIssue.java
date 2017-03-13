package com.nokia.example.Interview;

import com.nokia.example.Entity.UTEntity;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by YLongYao on 2016/11/1.
 */
public class SetIssue {

    /**
     * Set接口：
     *      不包含相同的元素，如果试图将相同的元素加入集合add方法返回false
     *      Set判断两个对象相等使用equals
     *
     * HashSet：
     *      底层使用哈希表实现的，底层使用HashMap来保存所有元素
     *      重写equals和hashcCode方法(且必须两个都重写)可以去重复：
     *          向HashSet集合添加元素时，会调用对象的hashCode方法来得到该对象的hashCode值
     *          然后根据hashCode值来确定该对象在HashSet中存储的位置（判断标准：
     *          通过对象的equals方法比较相等，且两个对象的hashCode()方法返回的值相等）
     *      如果要将一个对象放入HashSet中，应该重写该对像的equals和hashCode方法
     *      不能保证元素的顺序，不同步,集合元素可以是null，
     *
     * LinkedHashSet：
     *      继承于HashSet又基于LinkedHashMap来实现的，底层使用的LinkedHashMap来保存元素
     *      根据元素的HashCode值来确定元素位置，同时使用链表维护元素次序，
     *      访问集合时LinkedHashSet将会以元素的添加顺序访问元素
     *      LinkedHashSet在迭代访问Set中的全部元素时，性能比HashSet好，但插入时性能稍逊于HashSet
     *      同样会去出重复值(重写equals方法和hashCode方法)
     *      集合元素可以是null
     *
     * TreeSet：
     *      SortedSet接口的唯一实现类，可以保证元素处于排序转态，
     *      且支持自然排序和定制排序
     *          自然排序：默认排序，使用要排序元素的CompareTo方法来比较元素之间的大小
     *          定制排序：使用Comparator接口
     *      判断两个对象是通过equals方法或者CompareTo方法比较有没有返回0
     *      不允许放如null值，且数据自动排序好的，不可重复
     *      底层是由红黑树实现的，如果向TreeSet中插入对象，需要实现Comparable接口
     *
     * Iterator和ListIterator的区别：
     *      Iterator可以用来遍历Set和List，但是ListIterator只能用来遍历List
     *      Iterator只能向前遍历，但是ListIterator既可以向前遍历也可以向后遍历
     *      ListIterator实现了Iterator接口
     */

    @Test
    public void LinkedHashSetTest(){
        {
            LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add(1);
            linkedHashSet.add(6);
            linkedHashSet.add(2);
            linkedHashSet.add(1);
            linkedHashSet.add(10);
            linkedHashSet.add(7);
            linkedHashSet.add(3);
            linkedHashSet.add(1);
            linkedHashSet.add(null);
            linkedHashSet.forEach(val -> {
                System.out.println("linkedHashSet:" + val);
            });
        }
        {
            LinkedHashSet<UTEntity> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add(new UTEntity(1  , "name"));
            linkedHashSet.add(new UTEntity(2  , "name"));
            linkedHashSet.add(new UTEntity(1  , "name"));
            linkedHashSet.add(new UTEntity(3  , "name"));
            linkedHashSet.add(new UTEntity(1  , "kname"));
            linkedHashSet.add(new UTEntity(1  , "name"));
            linkedHashSet.add(new UTEntity(1  , "aname"));
            linkedHashSet.forEach(val -> {
                System.out.println("hashSet:" + val.toString() + " hashCode: " + val.hashCode());
            });
            System.out.println("hashSet size ==" + linkedHashSet.size());
        }
    }

    @Test
    public void TreeSetTest(){
        {
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(1);
            treeSet.add(12);
            treeSet.add(5);
            treeSet.add(7);
            treeSet.add(8);
            treeSet.add(10);
            treeSet.add(23);
            treeSet.add(2);
            treeSet.add(4);
            treeSet.forEach(val -> {
                System.out.println("hashSet:" + val);
            });
        }
        {
            TreeSet<UTEntity> hashSet = new TreeSet<UTEntity>();
            hashSet.add(new UTEntity(1  , "name"));
            hashSet.add(new UTEntity(2  , "name"));
            hashSet.add(new UTEntity(1  , "name"));
            hashSet.add(new UTEntity(3  , "name"));
            hashSet.add(new UTEntity(1  , "kname"));
            hashSet.add(new UTEntity(1  , "name"));
            hashSet.add(new UTEntity(1  , "aname"));
            hashSet.forEach(val -> {
                System.out.println("hashSet:" + val.toString() + " hashCode: " + val.hashCode());
            });
            System.out.println("hashSet size ==" + hashSet.size());
        }
    }

    @Test
    public void HashSetTest(){
        {
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(1);
            hashSet.add(1);
            hashSet.add(2);
            hashSet.add(null);
            hashSet.add(null);
            hashSet.forEach(val -> {
                System.out.println("hashSet:" + val);
            });
            System.out.println("hashSet size ==" + hashSet.size());
        }
        {
            HashSet<UTEntity> hashSet = new HashSet<UTEntity>();
            hashSet.add(new UTEntity(1  , "name"));
            hashSet.add(new UTEntity(2  , "name"));
            hashSet.add(new UTEntity(1  , "name"));
            hashSet.add(new UTEntity(3  , "name"));
            hashSet.add(new UTEntity(1  , "kname"));
            hashSet.add(new UTEntity(1  , "name"));
            hashSet.forEach(val -> {
                System.out.println("hashSet:" + val.toString() + " hashCode: " + val.hashCode());
            });
            System.out.println("hashSet size ==" + hashSet.size());
        }
    }

    @Test
    public void reflectTest(){
        try {
            Class clazz = Class.forName("com.nokia.example.Interview.ReflectIssue");
            Method method1 = clazz.getMethod("reflectPublic" , new Class[]{String.class});
            method1.invoke(clazz.newInstance() , new Object[]{"this is a public function"});

            Method method2 = clazz.getMethod("reflectPrivate" , new Class[]{String.class});
            method1.invoke(clazz.newInstance() , new Object[]{"this is a private function"});

            Method method3 = clazz.getDeclaredMethod("reflectPrivate" , new Class[]{String.class});
            method3.invoke(clazz.newInstance() , new Object[]{"this is a private function"});

            ((ReflectIssue)clazz.newInstance()).reflectPublic("this is a public function");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
