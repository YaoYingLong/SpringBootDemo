package com.nokia.UT;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author by YingLong on 2019/7/2
 */
public class FastJsonTest {

    @Test
    public void nullValueTest() {
        JSONObject json = new JSONObject();
        json.put("name", "小明");
        json.put("id", "");
        json.put("mobile", null);
        System.out.println(json);
        System.out.println(JSON.toJSONString(json, SerializerFeature.WriteMapNullValue));
    }

    @Test
    public void moneyCalculation() {
        // 超市东西：1590；名宿：600；圣诞树：160；共12人参与
        double segmentOne = 1059 + 600 + 160;
        double segmentOneAvg = segmentOne / 12.0;
        System.out.println("叶子：" + segmentOneAvg);
        System.out.println("糖糖：" + segmentOneAvg);

        // 唱歌：90；奶茶：99；共9人参与
        double segmentTwo = 90 + 99;
        double segmentTwoAvg = segmentTwo / 9;
        double qiShu = segmentTwoAvg + segmentOneAvg;
        System.out.println("琪琪：" + qiShu);
        System.out.println("苏苏：" + qiShu);

        // 羊肉：604；共7人参与
        double segmentThree = 604;
        double segmentThreeAvg = segmentThree / 7;
        double other = segmentThreeAvg + segmentTwoAvg + segmentOneAvg;
        System.out.println("所有项目都参与的人：" + other);

        double total = segmentOne + segmentTwo + segmentThree;
        System.out.println("第一阶段：" + segmentOne + ",平均花费：" + segmentOneAvg);
        System.out.println("第二阶段：" + segmentTwo + ",平均花费：" + segmentTwoAvg);
        System.out.println("第三阶段：" + segmentThree + ",平均花费：" + segmentThreeAvg);
        System.out.println("总花费：" + total);
        assertEquals(total, segmentOneAvg * 12 + segmentTwoAvg * 9 + segmentThreeAvg * 7, 0);
    }


}
