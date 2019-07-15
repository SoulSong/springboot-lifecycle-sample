package com.shf.spring.config;

import com.shf.spring.service.PersonService;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author songhaifeng
 * @date 2018/6/1
 */
@Component
@Slf4j
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * 可以通过BeanDefinitionRegistry注册更多的bean实例，也可以获取当前已经注册bean并进行属性的修改
     *
     * @param registry registry
     * @throws BeansException BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("run MyBeanDefinitionRegistryPostProcessor => postProcessBeanDefinitionRegistry,has register : {} beans", registry.getBeanDefinitionCount());
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(PersonService.class).getBeanDefinition();
        registry.registerBeanDefinition("personService2", beanDefinition);
    }

    /**
     * 此时仅完成了所有bean的注册工作，并没有实例化，我们可以对注册的bean重写或者添加一些属性
     *
     * @param beanFactory beanFactory
     * @throws BeansException BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("run MyBeanDefinitionRegistryPostProcessor => postProcessBeanFactory,has register : {} beans", beanFactory.getBeanDefinitionCount());
    }
}
