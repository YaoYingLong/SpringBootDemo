package com.nokia.example.Basics.CallBack;

/**
 * Created by YLongYao on 2016/10/18.
 */
public class Li {

    public void executeMessage(CallBack callBack, String question){
        System.out.println("小王问的问题--->" + question);

        for(int i=0; i<10000;i++){

        }

        String result = "答案是2";

        callBack.solve(result);
    }
}
