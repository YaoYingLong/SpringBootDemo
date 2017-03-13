package com.nokia.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Y31201308 on 2016/8/6.
 */
@Configuration
public class ThymeleafConfig {

    @Autowired
    public SpringTemplateEngine templateEngine;

    @PostConstruct
    public void extension(){
        Set<IDialect> dialects = new HashSet<IDialect>();
        dialects.add(springSecurityDialect());

        templateEngine.setAdditionalDialects(dialects);
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        SpringSecurityDialect dialect = new SpringSecurityDialect();
        return dialect;
    }

}
