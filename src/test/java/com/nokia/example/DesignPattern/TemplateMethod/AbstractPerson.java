package com.nokia.example.DesignPattern.TemplateMethod;

/**
 * 使用了Java的继承机制，在抽象类中定义一个模板方法，该方法引用了若干抽象方法（由子类去实现）
 * 或者具体方法（子类可以覆盖重写）
 *
 * 一般模板方法被定义为final避免被子类修改
 */
public abstract class AbstractPerson {

    public final void prepareGotoSchool(){
        derssUp();
        eatBreakfast();
        tackThings();
    }

    protected abstract void derssUp();
    protected abstract void eatBreakfast();
    protected abstract void tackThings();

}
