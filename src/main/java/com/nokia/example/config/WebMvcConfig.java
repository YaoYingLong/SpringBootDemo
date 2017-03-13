package com.nokia.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Y31201308 on 2016/8/11.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    public void addViewControllers(ViewControllerRegistry registry){
        //registry.addViewController("/index").setViewName("dashboard");
    }

}
