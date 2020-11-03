package com.nokia.example.DesignPattern.AbstractFactory;

import com.nokia.example.DesignPattern.AbstractFactory.impl.FemaleFactory;
import com.nokia.example.DesignPattern.AbstractFactory.impl.MaleFactory;
import org.junit.Test;

/**
 * @author by YingLong on 2020/11/3
 */
public class NvWa {

    @Test
    public void abstractFactoryTest() {
        HumanFactory maleHumanFactory = new MaleFactory();
        HumanFactory femaleHumanFactory = new FemaleFactory();
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();
    }

}
