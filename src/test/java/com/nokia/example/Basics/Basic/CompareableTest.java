package com.nokia.example.Basics.Basic;

import org.junit.Test;

import java.util.*;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class CompareableTest {
    /**
     * Comparable & Comparator 都是用来实现集合中元素的比较、排序的，
     * 只是 Comparable 是在集合内部定义的方法实现的排序，Comparator 是在集合外部实现的排序
     *
     * Comparator位于包java.util下，而Comparable位于包 java.lang下
     */

    @Test
    public void CompareableTest(){

        Person p1 = new Person("aaa" , 2);
        Person p2 = new Person("ddd" , 34);

        List<Person> list = new ArrayList<>();
        list.add(new Person("aaa" , 2));
        list.add(new Person("ggg" , 90));
        list.add(new Person("ddd" , 34));
        list.add(new Person("sss" , 23));
        list.add(new Person("kkk" , 30));
        Collections.sort(list , new PersonSort());
        list.forEach(person -> {
            System.out.println("name:"+person.name+"  age:"+person.age);
        });

        System.out.println("————————————————————————————");

        List<User> userList = new ArrayList<>();
        userList.add(new User("aaa" , 2));
        userList.add(new User("ggg" , 90));
        userList.add(new User("ddd" , 34));
        userList.add(new User("sss" , 23));
        userList.add(new User("kkk" , 30));
        Collections.sort(userList);
        userList.forEach(user -> {
            System.out.println("name:"+user.name+"  age:"+user.age);
        });

    }

    private class PersonSort implements Comparator<Person>{

        @Override
        public int compare(Person p1, Person p2) {
            int i = 0;
            i = p1.name.compareTo(p2.name); // 使用字符串的比较
            if(i == 0) { // 如果名字一样,比较年龄,返回比较年龄结果
                return p1.age - p2.age;
            } else {
                return i; // 名字不一样, 返回比较名字的结果.
            }
        }
    }

    class Person{

        public String name;
        public int age;

        public Person(String name , int age){
            this.name = name;
            this.age = age;
        }
    }

    class User implements Comparable<User>{

        public String name;
        public int age;

        public User(String name , int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User user) {
            int i = 0;
            i = name.compareTo(user.name); // 使用字符串的比较
            if(i == 0) { // 如果名字一样,比较年龄, 返回比较年龄结果
                return age - user.age;
            } else {
                return i; // 名字不一样, 返回比较名字的结果.
            }
        }
    }
}
