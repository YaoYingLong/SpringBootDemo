package com.nokia.example.DesignPattern.Builder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/11/4
 */
public class Client {

    @Test
    public void builderTest() {
        List<String> sequence = new ArrayList<>();
        sequence.add("engineBoom");
        sequence.add("start");
        sequence.add("stop");
        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);
        BenzModel benz = (BenzModel)benzBuilder.getCarModel();
        benz.run();
        BMWBuilder bmwBuilder = new BMWBuilder();
        bmwBuilder.setSequence(sequence);
        BMWModel bmw = (BMWModel)bmwBuilder.getCarModel();
        bmw.run();
    }

}
