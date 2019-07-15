package com.shf.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author songhaifeng
 * @date 2018/5/31
 */
@Component
@Order(0)
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        log.info("run my commandLineRunner");
    }
}
