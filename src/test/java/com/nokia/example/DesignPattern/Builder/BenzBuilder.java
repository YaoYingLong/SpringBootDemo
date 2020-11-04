package com.nokia.example.DesignPattern.Builder;

import java.util.List;

/**
 * @author by YingLong on 2020/11/4
 */
public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();
    @Override
    public void setSequence(List<String> sequence) {
        this.benz.setSequence(sequence);
    }
    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
