package com.nokia.example.annotation;

import com.nokia.example.model.PlayGame;
import com.nokia.example.service.impl.TaskServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author by YingLong on 2020/10/26
 */
public class AnnotationDemo {

    public static void main(String[] args) {
        {/**
         * 获取类注解属性
         */
            Class<TaskServiceImpl> taskServiceClass = TaskServiceImpl.class;
            boolean annotationPresent = taskServiceClass.isAnnotationPresent(InvokeListener.class);
            if (annotationPresent) {
                InvokeListener annotation = taskServiceClass.getAnnotation(InvokeListener.class);
                System.out.println(annotation.name());
                System.out.println(annotation.weight());
            }
        }

        {/**
         * 获取方法注解属性
         */
            try {
                Class<TaskServiceImpl> taskServiceClass = TaskServiceImpl.class;
                Field field = taskServiceClass.getDeclaredField("taskName");
                boolean annotationPresent = field.isAnnotationPresent(FieldListener.class);
                if (annotationPresent) {
                    FieldListener annotation = field.getAnnotation(FieldListener.class);
                    System.out.println(annotation.value());
                }

                Method play = PlayGame.class.getDeclaredMethod("play");
                if (play != null) {
                    People annotation = play.getAnnotation(People.class);
                    Game[] value = annotation.value();
                    for (Game game : value) {
                        System.out.println(game.value());
                    }
                }
            } catch (NoSuchFieldException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

}
