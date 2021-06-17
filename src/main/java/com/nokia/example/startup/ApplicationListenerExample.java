package com.nokia.example.startup;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author by YingLong on 2021/6/17
 */
@Log4j2
public class ApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            log.info("ApplicationListenerExample Startup");
        }
    }
}
