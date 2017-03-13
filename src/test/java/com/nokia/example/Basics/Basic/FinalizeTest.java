package com.nokia.example.Basics.Basic;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/11/8.
 */
public class FinalizeTest {

    /**
     * 用于一些不容易控制且非常重要的资源的释放，例如一些I/O操作，数据的连接等。
     */

    @Test
    public void FinalizeTest(){
        Cake cake1 = new Cake(1);
        Cake cake2 = new Cake(2);
        Cake cake3 = new Cake(3);

        cake1 = cake2 = null;
        System.gc();
    }

    private class Cake{
        private int id;
        public Cake(int id){
            this.id = id;
            System.out.println("Cake Object " + id + " is created.") ;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Cake Object "+ id + " id disposed.");
        }
    }
}
