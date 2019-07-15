package com.shf.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author songhaifeng
 * @date 2018/6/1
 */
@Component
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * 作用基本同于接口BeanDefinitionRegistryPostProcessor中定义的postProcessBeanFactory方法，
     * 此时仅完成了所有bean的注册工作，并没有实例化，我们可以对注册的bean重写或者添加一些属性
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("run MyBeanFactoryPostProcessor => postProcessBeanFactory,has register : {} beans", beanFactory.getBeanDefinitionCount());
    }
}
