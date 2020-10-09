package com.nokia.example.DesignPattern.Singleton;

/**
 * @author by YingLong on 2020/10/9
 */
public class EnumSingleton {

    private enum SingletonEnum {
        INSTANCE;
        private EnumSingleton singleton;

        private SingletonEnum() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }

    public static EnumSingleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}
