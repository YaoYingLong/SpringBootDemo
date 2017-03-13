package com.nokia.example.Basics.Basic;

/**
 * Created by YLongYao on 2016/11/13.
 */
public class BlockTest {

    public static BlockTest b1 = new BlockTest();
    public static BlockTest b2 = new BlockTest();

    {
        System.out.println("构造块");
    }

    static{
        System.out.println("静态块");
    }

    public static void main(String args[]){
        BlockTest b1 = new BlockTest();
//        BlockTest b2 = new BlockTest();
//        BlockTest  b3 = new BlockTest();
    }

}
