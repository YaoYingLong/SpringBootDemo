package com.nokia.example.DesignPattern.Builder;

import java.util.List;

/**
 * @author by YingLong on 2020/11/4
 */
public abstract class CarBuilder {

    public abstract void setSequence(List<String> seqence);

    public abstract CarModel getCarModel();

}
