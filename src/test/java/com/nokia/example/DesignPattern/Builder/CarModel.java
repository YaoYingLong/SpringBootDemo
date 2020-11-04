package com.nokia.example.DesignPattern.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/11/4
 */
public abstract class CarModel {
    private List<String> sequence = new ArrayList<>();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
    public final void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
    public final void run() {
        for (String actionName : sequence) {
            if ("start".equals(actionName)) {
                this.start();
            } else if ("stop".equals(actionName)) {
                this.stop();
            } else if ("alarm".equals(actionName)) {
                this.alarm();
            } else if ("engineBoom".equals(actionName)) {
                this.engineBoom();
            }
        }
    }
}
