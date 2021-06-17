package com.nokia.example.startup;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author by YingLong on 2021/6/17
 */
@Log4j2
public class NotifyListener implements ApplicationListener<NotifyEvent> {
    @Override
    public void onApplicationEvent(NotifyEvent event) {
        log.info("NotifyListener Startup");
    }
}
