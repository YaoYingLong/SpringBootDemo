package com.nokia.example.Serializable;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.nokia.example.Entity.UTEntity;
import com.nokia.example.model.Person;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by YLongYao on 2017/2/6.
 */
public class SerializableSimple implements Serializable{

    @Test
    public void serializeToDisk(){
        try{
            UTEntity ted = new UTEntity(1, "json");
            UTEntity charl = new UTEntity(2 , "xml");

            FileOutputStream fos = new FileOutputStream("tempdata.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ted);
            oos.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("tempdata.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            UTEntity ted = (UTEntity) ois.readObject();
            ois.close();

            assertEquals(ted.getType(), "json");

            // Clean up the file
            new File("tempdata.ser").delete();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void getProtobuff(){
        RuntimeSchema<Person> scheam = RuntimeSchema.createFrom(Person.class);
        Person person = new Person();
        person.setId(1);
        person.setName("xiaoming");
        person.setAddress("cd");
        person.setCity("cd");

        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] protostuff = null;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(person, scheam, buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            buffer.clear();
        }

        System.out.println("protostuff:" + protostuff.toString());

        Person person1 = scheam.newMessage();
        ProtobufIOUtil.mergeFrom(protostuff , person1 , scheam);

        System.out.println("person1:" + person1);
    }
}
