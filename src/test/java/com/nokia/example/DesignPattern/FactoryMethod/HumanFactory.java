package com.nokia.example.DesignPattern.FactoryMethod;

/**
 * @author by YingLong on 2020/11/3
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> clazz) {
        try {
            return (T) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人种生成错误");
        }
        return null;
    }
}
