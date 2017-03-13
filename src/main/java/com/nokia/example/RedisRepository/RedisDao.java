package com.nokia.example.RedisRepository;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.mysql.jdbc.Buffer;
import com.nokia.example.model.MyBatisModel.BaseEntity;
import com.nokia.example.model.Person;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by YLongYao on 2017/2/6.
 */
public class RedisDao {

    private final JedisPool jedisPool;

    public RedisDao(String ip, int port){
        jedisPool = new JedisPool(ip , port);
    }

    private RuntimeSchema<Person> scheam = RuntimeSchema.createFrom(Person.class);

    public Person getPersion(int id){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "";
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null){
                    Person person = scheam.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes , person , scheam);
                    //Person被反序列化
                    return person;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){

        }
        return null;
    }

    public String putPersion(Person person){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "id:"+ person.getId();
                byte[] bytes = ProtobufIOUtil.toByteArray(person , scheam , LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes() , timeout , bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
