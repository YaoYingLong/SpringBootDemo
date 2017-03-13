package com.nokia.IT;

import com.nokia.example.SpringBootDemoApplication;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootDemoApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class Log4j2Test {

    public static final Logger logger = LogManager.getLogger(Log4j2Test.class);

    @Test
    public void log4j2_Test(){
        logger.info("this is logger");
    }

}
