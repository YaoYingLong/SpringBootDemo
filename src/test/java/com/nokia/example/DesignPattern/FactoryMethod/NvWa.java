package com.nokia.example.DesignPattern.FactoryMethod;

import com.nokia.example.DesignPattern.FactoryMethod.impl.BlackHuman;
import com.nokia.example.DesignPattern.FactoryMethod.impl.WhiteHuman;
import com.nokia.example.DesignPattern.FactoryMethod.impl.YellowHuman;
import org.junit.Test;

/**
 * @author by YingLong on 2020/11/3
 */
public class NvWa {

    @Test
    public void factoryMethodTest() {
        //声明阴阳八卦炉
        //女娲第一次造人， 火候不足， 于是白人产生了
        AbstractHumanFactory YinYangLu = new HumanFactory();
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        //女娲第二次造人， 火候过足， 于是黑人产生了
        System.out.println("--造出的第二批人是黑色人种--");
        Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        //第三次造人， 火候刚刚好， 于是黄色人种产生了
        System.out.println("--造出的第三批人是黄色人种--");
        Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }


    /*@Test
    public void simpleFactory() {
        //女娲第一次造人， 火候不足， 于是白色人种产生了
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        //女娲第二次造人， 火候过足， 于是黑色人种产生了
        System.out.println("--造出的第二批人是黑色人种--");
        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        //第三次造人， 火候刚刚好， 于是黄色人种产生了
        System.out.println("--造出的第三批人是黄色人种--");
        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }*/
}
