package com.nokia.example.Interview;

import com.nokia.example.Entity.UTEntity;
import org.junit.Test;
import org.w3c.dom.Entity;
import sun.misc.resources.Messages_pt_BR;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class MapIssue {
    /**
     * Map接口：
     *      有四个实现类：HashMap、HashTable、LinkedHashMap、TreeMap
     *      用于存储键值对，根据键得到值，不允许重复键
     *
     * HashMap:
     *      根据键的hashCode存储值，允许一个空键,和多个空值，非线程同步的
     *      可以使用Collections.synchronizedMap(map);来使HasHMap具有同步能力
     *
     * HashTable:
     *      不允许记录的键和者值为空，支持线程同步，从而导致HashTable在写入时比较慢
     *
     * LinkedHashMap:
     *      保存记录的插入顺序，遍历时会比HashMap慢，具有HashMap的全部特性
     *      允许null键和null值
     *
     * TreeMap:
     *      能够把保存的记录根据键排序，默认按升序排序，也可以指定排序的比较器
     *      不允许null键和但是允许null值
     *
     * WeakHashMap:
     *      WeakHashMap是一种改进的HashMap，它对key实行“弱引用”，
     *      如果一个key不再被外部所引用，那么该key可以被GC回收
     */
    /**
     *  1、HashMap实际上是一个“链表的数组”的数据结构
     */

    /**
     *   HashSet实现Set接口，由哈希表（实际上是一个HashMap实例）支持。
     *   它不保证set 的迭代顺序；特别是它不保证该顺序恒久不变。此类允许使用null;
     *
     *    Set的实现类的集合对象中不能够有重复元素，HashSet也一样他是使用了一种标识来确定元素的不重复，
     *    HashSet用一种算法来保证HashSet中的元素是不重复的，
     *    HashSet采用哈希算法，底层用数组存储数据。默认初始化容量16，加载因子0.75
     */

    @Test
    public void TreeMapTest(){
        {
            Map<String, String> map = new TreeMap<>();
            map.put("sssk", "djf");
//        map.put(null , null);
            map.put("null", "null");
            map.put("kkk", null);
            map.put("sss", null);
            map.forEach((key, val) -> {
                if (key == null) {
                    System.out.println("this is a null key");
                }
                System.out.println("key=" + key + " val=" + val);
            });
        }
        {
            Map map = new TreeMap();
            map.put(new UTEntity(1  , "name") , "1");
            map.put(new UTEntity(3  , "name") , "1");
            map.put(new UTEntity(1  , "kname") , "1");
            map.put(new UTEntity(2  , "name") , "1");
            map.put(new UTEntity(1  , "aname") , "1");
            map.forEach((key, val) -> {
                System.out.println("key=" + key.toString() + " val=" + val);
            });
        }
    }

    @Test
    public void LinkedHashMapTest(){
        Map<String , String> map = new LinkedHashMap<>();
        map.put("sssk" , "djf");
        map.put(null , null);
        map.put("null" , "null");
        map.put("kkk" , null);
        map.put("sss" , null);
        map.forEach((key , val) -> {
            if(key == null){
                System.out.println("this is a null key");
            }
            System.out.println("key="+key+" val="+val);
        });
    }

    @Test
    public void HashTableTest(){
        Map<String , String> map = new Hashtable<>();
//        map.put(null , null);  运行时会抛出空指针异常
        map.put("null" , "null");
//        map.put("kkk" , null); 运行时会抛出空指针异常
//        map.put("sss" , null); 运行时会抛出空指针异常
        map.forEach((key , val) -> {
            if(key == null){
                System.out.println("this is a null key");
            }
            System.out.println("key="+key+" val="+val);
        });
    }

    @Test
    public void HashMapTest(){
        Map<String , String> map = new HashMap<String,String>();
        map.put(null , null);
        map.put("null" , "null");
        map.put("kkk" , null);
        map.put("sss" , null);
        map.forEach((key , val) -> {
            if(key == null){
                System.out.println("this is a null key");
            }
            System.out.println("key="+key+" val="+val);
        });

        for(Map.Entry<String , String> entity : map.entrySet()){
            System.out.println("key="+entity.getKey()+" val="+entity.getKey());
        }

        Collections.synchronizedMap(map);
    }

    @Test
    public void ConcurrentHashMapTest() {
        Map<String , String> map = new ConcurrentHashMap<String,String>();

    }
}
