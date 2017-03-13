package com.nokia.example;

import com.nokia.example.Util.PostUrl;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by YLongYao on 2016/8/16.
 */
public class MobileIntefaceTest {

    @Autowired
    PostUrl postUrl;

    @Test
    public void test001(){

        String urlPath = "http://localhost:8080/LuZhouFire/getUnit";

        String urlPath_TT = "http://localhost:8080/LuZhouFire/getUnit?policestation='泸州市公安局纳溪区分局大渡派出所'";

        String parameter = "{\"policestation\":\"泸州市公安局纳溪区分局大渡派出所\",\"checktype\":0}";
        PostUrl postUrl = new PostUrl();
        String returnJson = postUrl.getSubUrl(urlPath, parameter);

        System.out.println("returnJson=="+returnJson);
    }

    @Test
    public void test002(){

        java.lang.String s = new java.lang.String("this is a test.");
        System.out.print("s==="+s);
    }




}
