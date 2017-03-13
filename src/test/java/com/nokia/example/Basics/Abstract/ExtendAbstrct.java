package com.nokia.example.Basics.Abstract;

import org.junit.Test;

public class ExtendAbstrct extends AbstractClassA{

    @Override
    protected void MethodA() {

    }

    @Override
    void MethodC() {

    }

    @Override
    public void MethodD() {
        System.out.println("this is AbstractClassA method d");
    }

    @Test
    public void superTest(){
        /**
         * super关键字既能调用父类的属性，也能调用父类的方法
         * super不能出现在static关键字修饰的方法中
         * super只能指代直接父类
         */
        super.MethodF();
        String p = super.para;
        System.out.println(super.para);
    }

    @Test
    public void ClassOrMethodNameTest(){
        String sName = super.getClass().getName();
        String sCanonicalName = super.getClass().getCanonicalName();
        String sSimpleName = super.getClass().getSimpleName();
        String sTypeName = super.getClass().getTypeName();

        System.out.println("super name:"+sName);
        System.out.println("super canonicalName:"+sCanonicalName);
        System.out.println("super simpleName:"+sSimpleName);
        System.out.println("super typeName:"+sTypeName);
        System.out.println("------------------------------------------");

        String tName = this.getClass().getName();
        String tCanonicalName = this.getClass().getCanonicalName();
        String tSimpleName = this.getClass().getSimpleName();
        String tTypeName = this.getClass().getTypeName();

        System.out.println("this name:"+tName);
        System.out.println("this canonicalName:"+tCanonicalName);
        System.out.println("this simpleName:"+tSimpleName);
        System.out.println("this typeName:"+tTypeName);

    }
}
