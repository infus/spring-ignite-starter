package ru.vtb.dbo.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.vtb.dbo.bean.factory.IgniteBeanFactory;

public class IgniteApplicationContext extends AnnotationConfigApplicationContext {
    public IgniteApplicationContext() {
        super(new IgniteBeanFactory());
    }
}
