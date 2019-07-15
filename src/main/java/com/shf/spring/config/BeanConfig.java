package com.shf.spring.config;

import com.shf.spring.service.UserService;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author songhaifeng
 * @date 2018/5/31
 */
@Configuration
public class BeanConfig {

    @Autowired(required = false)
    private List<UserService> userServices;

    @Bean
    public SmartInitializingSingleton smartInitializingSingleton() {
        return () -> {
            userServices.forEach(UserService::callback);
        };
    }

    @Bean("deptService")
    public DeptFactoryBean deptService() {
        return new DeptFactoryBean();
    }
}
