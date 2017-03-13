package com.nokia.example.DesignPattern.TemplateMethod;

/**
 * Created by YLongYao on 2016/11/6.
 */
public class Teacher extends AbstractPerson{
    @Override
    protected void derssUp() {
        System.out.println("穿工作服");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("做早饭，照顾孩子吃早饭");
    }

    @Override
    protected void tackThings() {
        System.out.println("带上昨天晚上准备的考卷");
    }
}
