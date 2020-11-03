package com.nokia.example.DesignPattern.FactoryMethod;

import com.nokia.example.DesignPattern.FactoryMethod.impl.BlackHuman;
import com.nokia.example.DesignPattern.FactoryMethod.impl.WhiteHuman;
import com.nokia.example.DesignPattern.FactoryMethod.impl.YellowHuman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by YingLong on 2020/11/3
 */
public class ProductFactory {
    private static final Map<String, Human> humanMap = new HashMap<>();
    public static synchronized Human createHuman(String type) throws Exception {
        Human human;
        if (humanMap.containsKey(type)) {
            human = humanMap.get(type);
        } else {
            if (type.equals("BlackHuman")) {
                human = new BlackHuman();
            } else if (type.equals("WhiteHuman")) {
                human = new WhiteHuman();
            } else {
                human = new YellowHuman();
            }
            humanMap.put(type, human);
        }
        return human;
    }
}
