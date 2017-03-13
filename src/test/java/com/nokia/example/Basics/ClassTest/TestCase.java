package com.nokia.example.Basics.ClassTest;

/**
 * Created by YLongYao on 2016/10/26.
 */
public class TestCase {
    public static void main(String[]args) {
        InnerClass eo = new InnerClass();
        InnerClass.InsideOne a = eo.new InsideOne();
    }
}
