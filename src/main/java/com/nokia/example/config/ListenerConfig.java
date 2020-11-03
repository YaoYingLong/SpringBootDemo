package com.nokia.example.config;

import com.nokia.example.annotation.FieldListener;
import com.nokia.example.annotation.InvokeListener;
import com.nokia.example.annotation.MethodListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author by YingLong on 2020/10/26
 */
public class ListenerConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(InvokeListener.class);
        for (Object bean : beanMap.values()) {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                FieldListener fieldListener = field.getAnnotation(FieldListener.class);
                if (fieldListener != null) {
                    System.out.println(fieldListener.value());
                }
            }
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                MethodListener methodListener = method.getAnnotation(MethodListener.class);
                if (methodListener != null) {
                    System.out.println(methodListener.value());
                }
            }
        }
    }
}
