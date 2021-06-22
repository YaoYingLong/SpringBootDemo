package com.nokia.UT;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * @author by YingLong on 2021/6/22
 */
public class StringUtil {

    @Test
    public void commonsLang3Test() throws ParseException {
        {
            String str = "yideng";
            String capitalize = StringUtils.capitalize(str);
            System.out.println(capitalize); // 输出Yideng
        }
        {
            String str = StringUtils.repeat("ab", 2);
            System.out.println(str); // 输出abab
        }
        {
            {
                // Date类型转String类型
                String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                System.out.println(date); // 输出 2021-05-01 01:01:01
            }
            // String类型转Date类型
            {
                Date date = DateUtils.parseDate("2021-05-01 01:01:01", "yyyy-MM-dd HH:mm:ss");
            }

            // 计算一个小时后的日期
            {
                Date date = DateUtils.addHours(new Date(), 1);
            }
        }
        {
            // 返回两个字段
            ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "test");
            System.out.println(pair.getLeft() + "," + pair.getRight()); // 输出 1,yideng
            // 返回三个字段
            ImmutableTriple<Integer, String, Date> triple = ImmutableTriple.of(1, "test", new Date());
            System.out.println(triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight());
            // 输出 1,yideng,Wed Apr 07 23:30:00 CST 2021
        }
    }

    @Test
    public void beanutilsTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "id", 1);
        BeanUtils.setProperty(user, "name", "yideng");
        System.out.println(BeanUtils.getProperty(user, "name")); // 输出 yideng
        System.out.println(JSON.toJSONString(user)); // 输出 {"id":1,"name":"yideng"}


        // 对象转map
        Map<String, String> map = BeanUtils.describe(user);
        System.out.println(map); // 输出 {"id":"1","name":"yideng"}
// map转对象
        User newUser = new User();
        BeanUtils.populate(newUser, map);
        System.out.println(newUser); // 输出 {"id":1,"name":"yideng"}
    }

}
