package com.nokia.example.Basics.Basic;

/**
 * Created by YLongYao on 2016/10/25.
 */
public class StaticParameter {
    private static int x = 100;

    public static void main(String[] args){
        StaticParameter hs1 = new StaticParameter();
        hs1.x++;
        StaticParameter hs2 = new StaticParameter();
        hs2.x++;
        hs1 = new StaticParameter();
        hs1.x++;
        StaticParameter.x--;
        System.out.println(" x = " + x);  //102
    }
}
