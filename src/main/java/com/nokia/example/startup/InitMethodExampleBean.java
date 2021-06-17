package com.nokia.example.startup;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author by YingLong on 2021/6/17
 */
@Log4j2
@Component
public class InitMethodExampleBean {
    @Autowired
    private Environment environment;

    public void init() {
        log.info(Arrays.asList(environment.getDefaultProfiles()));
    }

    @Bean(initMethod="init")
    public InitMethodExampleBean initMethodExampleBean() {
        return new InitMethodExampleBean();
    }
}
