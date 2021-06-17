package com.nokia.example.DesignPattern.Mediator;

/**
 * @author by YingLong on 2021/4/12
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
