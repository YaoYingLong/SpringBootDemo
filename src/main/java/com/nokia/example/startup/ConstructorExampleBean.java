package com.nokia.example.startup;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author by YingLong on 2021/6/17
 */
@Log4j2
@Component
public class ConstructorExampleBean {
    private final Environment environment;

    @Autowired
    public ConstructorExampleBean(Environment environment) {
        this.environment = environment;
        log.info(Arrays.asList(environment.getDefaultProfiles()));
    }
}
