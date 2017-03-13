package com.nokia.example.DesignPattern.TemplateMethod;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/6.
 */
public class Client {

    @Test
    public void TempletMethodTest(){
        Student student = new Student();
        student.prepareGotoSchool();

        Teacher teacher = new Teacher();
        teacher.prepareGotoSchool();
    }

}
