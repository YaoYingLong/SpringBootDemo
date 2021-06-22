package com.nokia.example.DesignPattern.command;

/**
 * @author by YingLong on 2021/6/21
 */
public class ConcreteCommand2 extends Command {
    public ConcreteCommand2() {
        super(new ConcreteReceiver2());
    }
    public ConcreteCommand2(Receiver receiver) {
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
