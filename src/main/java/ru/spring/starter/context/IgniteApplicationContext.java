package ru.spring.starter.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.spring.starter.bean.factory.IgniteBeanFactory;

public class IgniteApplicationContext extends AnnotationConfigApplicationContext {
    public IgniteApplicationContext() {
        super(new IgniteBeanFactory());
    }
}
