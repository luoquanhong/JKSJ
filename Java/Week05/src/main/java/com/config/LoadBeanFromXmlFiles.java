package com.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadBeanFromXmlFiles {

    ApplicationContext applicationContext = null;

    public ApplicationContext loadBeanFromXmlFiles(String classPathFilePath) {
        return applicationContext = new ClassPathXmlApplicationContext(classPathFilePath);
    }
}
