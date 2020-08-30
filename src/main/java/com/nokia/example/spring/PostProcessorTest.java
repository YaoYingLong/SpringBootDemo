package com.nokia.example.spring;

import com.nokia.example.spring.CustomBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author by YingLong on 2020/8/28
 */
public class PostProcessorTest {

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.refresh();
        CustomBean bean = (CustomBean) context.getBean("customBean");
        System.out.println("################ 实例化、初始化bean完成");
        System.out.println("****************下面输出结果");
        System.out.println("描述：" + bean.getDesc());
        System.out.println("备注：" + bean.getRemark());
    }

}
