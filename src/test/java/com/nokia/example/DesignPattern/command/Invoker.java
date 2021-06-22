package com.nokia.example.DesignPattern.command;

/**
 * @author by YingLong on 2021/6/21
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
