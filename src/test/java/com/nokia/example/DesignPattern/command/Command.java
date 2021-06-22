package com.nokia.example.DesignPattern.command;

/**
 * @author by YingLong on 2021/6/21
 */
public abstract class Command {
    //定义一个子类的全局共享变量
    protected final Receiver receiver;
    //实现类必须定义一个接收者
    public Command(Receiver _receiver){
        this.receiver = _receiver;
    }
    public abstract void execute();
}
