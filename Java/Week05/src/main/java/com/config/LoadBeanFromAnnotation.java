package com.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoadBeanFromAnnotation {

    ApplicationContext applicationContext = null;

    public ApplicationContext loadBeanFromXmlAnnotation(String... basePackages) {
        return applicationContext = new AnnotationConfigApplicationContext(basePackages);
    }
}
