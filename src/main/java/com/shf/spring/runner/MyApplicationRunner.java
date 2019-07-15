package com.shf.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 可以通过@Order注解定义ApplicationRunner和CommandLineRunner的执行顺序
 *
 * @author songhaifeng
 * @date 2018/5/31
 */
@Component
@Order(1)
@Slf4j
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("run my ApplicationRunner");
    }
}
