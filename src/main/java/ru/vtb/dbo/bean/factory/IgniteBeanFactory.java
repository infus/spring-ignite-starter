/**
 * Copyright 2017 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ru.vtb.dbo.bean.factory;

import java.util.Set;

import org.apache.ignite.Ignite;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import ru.vtb.dbo.annotation.IgniteResource;
import ru.vtb.dbo.configuration.IgniteSpringBootConfiguration;
import ru.vtb.dbo.properties.DefaultIgniteProperties;

public class IgniteBeanFactory extends DefaultListableBeanFactory {

    private IgniteSpringBootConfiguration configuration;

    @Override
    public Object resolveDependency(final DependencyDescriptor descriptor, final String beanName,
                                    final Set<String> autowiredBeanNames, final TypeConverter typeConverter)
            throws BeansException {
        if (descriptor == null
                || descriptor.getField() == null
                || !descriptor.getField().getType().equals(Ignite.class)) {
            return super.resolveDependency(descriptor, beanName, autowiredBeanNames, typeConverter);
        } else {
            if (configuration == null) {
                configuration = new IgniteSpringBootConfiguration(createBean(DefaultIgniteProperties.class));
            }
            final IgniteResource[] annotationsByType = descriptor.getField().getAnnotationsByType(IgniteResource.class);
            return configuration.getIgnite(annotationsByType);
        }
    }
}
