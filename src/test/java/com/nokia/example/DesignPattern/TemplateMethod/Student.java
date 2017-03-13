package com.nokia.example.DesignPattern.TemplateMethod;

/**
 * Created by YLongYao on 2016/11/6.
 */
public class Student extends AbstractPerson{

    @Override
    protected void derssUp() {
        System.out.println("穿衣服");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("吃妈妈做的早餐");
    }

    @Override
    protected void tackThings() {
        System.out.println("背书包，带上家庭作业和红领巾");
    }

}
