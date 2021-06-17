package com.nokia.example.startup;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author by YingLong on 2021/6/17
 */
@Log4j2
@Component
public class ApplicationStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationStartupRunner Startup: {}", args.getOptionNames());
    }
}
