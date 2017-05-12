/**
 * Copyright 2017 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ru.vtb.dbo.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.vtb.dbo.bean.factory.IgniteBeanFactory;

public class IgniteApplicationContext extends AnnotationConfigApplicationContext {
    public IgniteApplicationContext() {
        super(new IgniteBeanFactory());
    }
}
