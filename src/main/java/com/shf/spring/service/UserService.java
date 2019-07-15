package com.shf.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author songhaifeng
 * @date 2018/5/31
 */
@Service
@Slf4j
public class UserService {

    public UserService() {
        log.info("run UserService constructor.");
    }

    public void callback() {
        log.info("run UserService callback.");
    }

    public void doSth() {
        log.info("run UserService doSth.");
    }

    @PostConstruct
    private void init(){
        log.info("run UserService init.");
    }

    @PreDestroy
    private void destroy(){
        log.info("run UserService destroy.");
    }
}
