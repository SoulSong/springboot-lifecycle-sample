package com.shf.spring.config;

import com.shf.spring.service.RoleService;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过BeanDefinitionRegistry手工注册bean实例
 *
 * @author songhaifeng
 * @date 2018/6/1
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (beanDefinitionRegistry.containsBeanDefinition("userService")) {
            //注册一个Bean，指定bean名
            beanDefinitionRegistry.registerBeanDefinition("roleService", new RootBeanDefinition(RoleService.class));
        }
    }
}
