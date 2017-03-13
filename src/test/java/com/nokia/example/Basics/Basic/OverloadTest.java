package com.nokia.example.Basics.Basic;

/**
 * Created by YLongYao on 2016/11/7.
 */
public class OverloadTest {

    /**
     * 返回类型可以不同，但是参数顺序和个数相同仅仅返回类型不同是不行的
     */

    public void overloadTest(){

    }
//    不能
//    private void overloadTest(){
//
//    }


    private void overloadTest(String k){

    }

//    不能
//    private String overloadTest(String k){
//        return k;
//    }

    public String overloadTest(String k , int s){
        return k;
    }

    public String overloadTest(int s , String k){
        return k;
    }
}
