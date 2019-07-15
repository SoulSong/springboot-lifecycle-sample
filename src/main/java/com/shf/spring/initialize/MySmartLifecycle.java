package com.shf.spring.initialize;

import com.shf.spring.service.PersonService;
import com.shf.spring.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * 在所有的bean加载实例化完成后方会执行start方法
 *
 * @author songhaifeng
 * @date 2018/5/31
 */
@Component
@Slf4j
public class MySmartLifecycle implements SmartLifecycle, ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public boolean isAutoStartup() {
        log.info("run SmartLifecycle : isAutoStartup");
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        log.info("run SmartLifecycle : stop");
    }

    @Override
    public void start() {
        log.info("run SmartLifecycle : start,has {} beans", applicationContext.getBeanDefinitionCount());
        log.info("RoleService beanName :: {}", (Object) applicationContext.getBeanNamesForType(RoleService.class));
        log.info("PersonService beanName :: {}", (Object) applicationContext.getBeanNamesForType(PersonService.class));
        log.info("DeptService bean :: {}", applicationContext.getBean("deptService"));
        log.info("DeptFactoryBean bean :: {}", applicationContext.getBean("&deptService"));
    }

    @Override
    public void stop() {
        log.info("run SmartLifecycle : stop");
    }

    @Override
    public boolean isRunning() {
        log.info("run SmartLifecycle : isRunning");
        return false;
    }

    @Override
    public int getPhase() {
        log.info("run SmartLifecycle : getPhase");
        return 0;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
