package com.nokia.example.startup;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author by YingLong on 2021/6/17
 */
@Log4j2
@Component
@Scope(value = "prototype")
public class AllStrategiesExampleBean implements InitializingBean {
    public AllStrategiesExampleBean() {
        log.info("Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("PostConstruct");
    }

    public void init() {
        log.info("init-method");
    }
}
