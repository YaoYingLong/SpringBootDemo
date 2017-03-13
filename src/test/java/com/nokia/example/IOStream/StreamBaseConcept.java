package com.nokia.example.IOStream;

/**
 * Created by YLongYao on 2017/2/15.
 */
public class StreamBaseConcept {
    /**
     * 流概念和作用：
     *      流是一组有顺序有起点和终点的字节集合，对数据传输的总称和抽象。即数据在两设备之间传输称为流，
     *      流的本质是数据传输，根据数据传输的特性将流抽象为各种类
     *
     * IO流的分类：
     *      根据数据处理类型的不同：字节流、字符流
     *      根据数据流向的不同：输出流、输入流
     *
     * 字节流与字符流的区别：
     *      读写单位不同：字节流以字节（8bit）为单位，字符流以字符为单位，一次可以读取多个字节
     *      处理对象不同：字节流能处理所有类型的数据，而字符流只能处理字符类型的数据
     *      只要处理纯文本数据，优先考虑使用字符流
     *
     * Java IO对象：
     *      InputStream是所有输入字节流的父类，是一个抽象类
     *      ByteArrayInputStream、StringBufferInputStream、FileInputStream是三种基本的介质流，它们分别中Byte数组
     *      StringBuffer、和本地文件中读取数据
     */
}
