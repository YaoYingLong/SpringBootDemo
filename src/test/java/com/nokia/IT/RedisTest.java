package com.nokia.IT;

import com.nokia.example.RedisRepository.RedisUtil;
import com.nokia.example.SpringBootDemoApplication;
import com.nokia.example.model.Person;
import com.nokia.example.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootDemoApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BaseService baseService;

    @Test
    public void redisCacheableTest(){
        Person person = new Person();
        person.setName("kkkk");
        String name = baseService.BaseInfo(person);
        System.out.println("name:" + name);
        boolean isExist =  redisTemplate.hasKey("com.nokia.example.service.BaseServiceHanderBaseInfoPerson{id=null, name='kkkk', address='null', city='null'}");
        System.out.println("isExist:" + isExist);

        String name1 = baseService.BaseInfo(person);
        System.out.println("name1:" + name1);
        System.out.println("isExist1:" + redisTemplate.hasKey("com.nokia.example.service.BaseServiceHanderBaseInfoPerson{id=null, name='kkkk', address='null', city='null'}"));
    }

    @Test
    public void redisAddDateTest(){
        String key = "";
        String value = "";
        ValueOperations<Serializable, Object> operations0 = redisTemplate.opsForValue();
        operations0.set(key, value);


        ValueOperations<Serializable, Object> operations1 = redisTemplate.opsForValue();
        Object result = operations1.get(key);
    }

    @Test
    public void redisBaseTest(){

        String key = "jjj";
        boolean isExist =  redisTemplate.hasKey(key);
        System.out.println("isExist:" + isExist);

        System.out.println("isExist foo:" + redisTemplate.hasKey("foo"));
        if(redisTemplate.hasKey("foo")){
            ValueOperations<Serializable, Object> operations1 = redisTemplate.opsForValue();
            Object result = operations1.get("foo");
            System.out.println("result:" + result);
        }
    }
}
