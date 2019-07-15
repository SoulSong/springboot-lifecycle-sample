package com.shf.spring.config;

import com.shf.spring.service.DeptService;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author songhaifeng
 * @date 2018/6/1
 */
public class DeptFactoryBean implements FactoryBean<DeptService> {
    /**
     * 获取bean时需要采用&deptService作为beanName
     *
     * @return
     * @throws Exception
     */
    @Override
    public DeptService getObject() throws Exception {
        return new DeptService();
    }

    @Override
    public Class<?> getObjectType() {
        return DeptService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
