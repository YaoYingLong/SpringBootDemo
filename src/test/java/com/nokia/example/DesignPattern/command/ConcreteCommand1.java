package com.nokia.example.DesignPattern.command;

/**
 * @author by YingLong on 2021/6/21
 */
public class ConcreteCommand1 extends Command {
    public ConcreteCommand1() {
        super(new ConcreteReceiver1());
    }
    public ConcreteCommand1(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.find();
        this.receiver.add();
        this.receiver.delete();
        this.receiver.update();
    }
}
