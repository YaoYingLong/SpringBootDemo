package com.nokia.example.Basics.DownCast;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/18.
 */
public class Downcast {

    @Test
    public void DowncastTest() {
        Animal b=new Bird(); //向下转型
        b.eat();
        //b.fly(); 此处提示在Animal中没有定义fly方法。
        ((Bird)b).fly();
    }

    class Animal {
        public void eat() {
            System.out.println("animal eatting...");
        }

    }

    class Bird extends Animal {
        public void eat() {
            System.out.println("bird eatting...");
        }

        public void fly() {
            System.out.println("bird flying...");
        }
    }
}