package com.nokia.example.config;

import com.nokia.example.proxy.EnhaceInvocationHandler;
import com.nokia.example.service.BaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableTransactionManagement
@EnableScheduling
public class SpringBootConfiguration {
    @Bean(name = {"baseService"})
    @Value("#{baseService_underProxy}")
    public BaseService getBaseServicesProxy(BaseService service) {
        return (BaseService) Proxy.newProxyInstance(BaseService.class.getClassLoader(),
                new Class[]{BaseService.class},
                new EnhaceInvocationHandler(service));
    }

    /*************************************
     * Data source
     **************************************/
    @Bean(name = {"transactionManager"})
    @Value("#{dataSource}")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
        org.springframework.jdbc.datasource.DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
        return tm;
    }

    @Bean
    public ThreadPoolTaskExecutor processExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }
}
