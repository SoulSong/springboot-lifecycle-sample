package com.shf.spring.config;

import com.shf.spring.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器：初始化前后进行处理工作
 *
 * @author songhaifeng
 * @date 2018/5/31
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    /**
     * 优先于bean实例的init(@PostConstruct方法)
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserService){
            LOGGER.info("run postProcessBeforeInitialization..."+beanName+"=>"+bean);
        }
        return bean;
    }

    /**
     * 执行于bean实例的init(@PostConstruct方法)之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserService){
            LOGGER.info("run postProcessAfterInitialization..."+beanName+"=>"+bean);
        }
        return bean;
    }
}
