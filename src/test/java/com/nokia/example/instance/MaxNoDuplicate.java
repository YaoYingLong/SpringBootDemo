package com.nokia.example.instance;

import org.junit.Test;

/**
 * Created by YLongYao on 3/8/2017.
 */
public class MaxNoDuplicate {

    public String noDuplicate(String str) {
        String sub = "", result = "";
        for (int i = 0; i < str.length(); i++) {
            String c = "" + str.charAt(i);
            if (sub.contains(c)) {
                if (sub.length() > result.length()) {
                    result = sub;
                }
                sub = "";
            }
            sub += c;
        }
        if (sub.length() > result.length()) {
            result = sub;
        }
        return result;
    }

    @Test
    public void noDuplicateTest(){
        String str = "sdjfsdlfajldfjlkasjdlfajslkdfdsfwe";
        System.out.println(noDuplicate(str));
    }

}
