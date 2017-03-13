package com.nokia.example.Basics.Basic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YLongYao on 2016/10/30.
 */
public class FirstRepeatCharFromTargetStr {

    public String getStr(String str){
        Map<String , Integer> strMap = new HashMap<>();
        for (int i=0;i<str.length();i++){
            String k = String.valueOf(str.charAt(i));
            if(strMap.get(k) == null){
                strMap.put(k , 1);
            }else{
                int s = strMap.get(k);
                strMap.put(k , s+1);
            }
        }
        for (int i=0;i<str.length();i++){
            String k = String.valueOf(str.charAt(i));
            if(strMap.get(k) == 1){
                return k;
            }
        }
        return null;
    }

    @Test
    public void testStrMap(){
        String k = "a121ddbksab";
        System.out.println("k=="+getStr(k));
    }

}
