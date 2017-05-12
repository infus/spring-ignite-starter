package ru.spring.starter.bean.factory;

import java.util.Set;

import org.apache.ignite.Ignite;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import ru.spring.starter.annotation.IgniteResource;
import ru.spring.starter.configuration.IgniteSpringBootConfiguration;
import ru.spring.starter.properties.DefaultIgniteProperties;

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
