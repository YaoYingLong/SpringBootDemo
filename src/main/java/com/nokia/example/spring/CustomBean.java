package com.nokia.example.spring;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author by YingLong on 2020/8/28
 */
public class CustomBean implements InitializingBean {

    private String desc;
    private String remark;

    public CustomBean() {
        System.out.println("第二步：执行CustomBean类的无参构造函数");
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        System.out.println("第三步：调用setDesc方法");
        this.desc = desc;
    }

    public String getRemark() {
        System.out.println("第四步：调用setRemark方法");
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：调用afterPropertiesSet方法");
        this.desc = "在初始化方法中修改之后的描述信息";
    }

    public void initMethod() {
        System.out.println("第七步：调用initMethod方法");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[描述：").append(desc);
        builder.append("， 备注：").append(remark).append("]");
        return builder.toString();
    }
}
