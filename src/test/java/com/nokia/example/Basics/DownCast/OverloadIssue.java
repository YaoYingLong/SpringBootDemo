package com.nokia.example.Basics.DownCast;

/**
 * Created by YLongYao on 2016/10/22.
 */
public class OverloadIssue {

    public void TargetFunction(){

    }
    public void TargetFunction(String parameter){

    }
    public String TargetFunction(int parameter){
        return "";
    }
    public void TargetFunction(int a,String b){

    }
    public void TargetFunction(String a,int b){

    }
    public Double TargetFunction(boolean flag){
        return 0d;
    }

    public final void finalTest(){

    }

    public final void finalTest(String kk){

    }
}
