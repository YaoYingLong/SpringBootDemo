package com.nokia.example.Basics.ClassTest;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/19.
 */
class Person{
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}

class Employee extends Person {
    String empID = "0000";

    public Employee(String id) {
        super("kkk");
        empID = id;
    }
}

public class ClassTest {

    private class C {
        C() {
            System.out.print("C");
        }
    }

    private class A {
        C c = new C();
        A() {
            this("A");
            System.out.print("A");
        }

        A(String s) {
            System.out.print(s);
        }
    }

    private class B extends A {
        B() {
            super();
            //super("B");
            System.out.print("B");
        }
    }

    @Test
    public void TestClass() {
        new B();
    }

    @Test
    public void EmployeeTest(){
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }

}
