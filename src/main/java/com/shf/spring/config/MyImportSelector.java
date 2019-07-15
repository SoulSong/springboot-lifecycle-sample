package com.shf.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author songhaifeng
 * @date 2018/6/1
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值，就是到导入到容器中的组件全类名
     *
     * @param annotationMetadata 标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.shf.spring.service.PersonService"};
    }
}
