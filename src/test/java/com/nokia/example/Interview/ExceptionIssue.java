package com.nokia.example.Interview;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by YLongYao on 2016/11/2.
 */
public class ExceptionIssue {

    /**
     * Exception和Error的区别：
     *      都是Throwable的子类。
     *      Exception用于用户程序可以捕获的异常。
     *      Error定义了不期望被用户程序捕获的异常。
     *
     * 常见的异常：
     *      NullPointerException空指针
     *      ClassNotFindException指定的类不存在异常
     *      ArrayIndexOutOfBoundsException数组下标越界异常
     *      IllegalArgumentException方法参数错误
     *      FileNotFoundException文件未找到异常
     *      IOException输入输出异常
     *      SQLException数据库操作异常
     *      NoSuchMethodException方法未找到异常
     *      NumberFormatException字符串转为数字异常
     *
     *
     * throw和throws的区别：
     *      throw用来在程序中明确抛出的异常。
     *      throws用来表明方法不能处理的异常。
     *
     * 异常处理完成后，Exception对象将发生什么：
     *      在下一个垃圾回收过程中被回收。
     */

    @Test
    public void ExceptionTest(){
        try {
            throw new IOException("this is a IOException");
        }catch (FileNotFoundException e){
            System.out.println("throw a FileNotFoundException");
        }catch(IOException e){
            System.out.println("throw a IOException");
        }catch (Exception e){
            System.out.println("throw a Exception");
        }
    }
}
