package com.nokia.example.Basics.CallBack;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/18.
 */
public class TestCallBack {
    @Test
    public void t(){
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1 + 1 = ?");
    }

}
