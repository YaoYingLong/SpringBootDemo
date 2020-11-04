package com.nokia.example.DesignPattern.Builder;

import java.util.List;

/**
 * @author by YingLong on 2020/11/4
 */
public class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();
    @Override
    public void setSequence(List<String> sequence) {
        this.bmw.setSequence(sequence);
    }
    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
}
