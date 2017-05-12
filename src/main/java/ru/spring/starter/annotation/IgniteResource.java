package ru.spring.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Autowired
public @interface IgniteResource {
    String gridName();
    boolean clientMode() default true;
    boolean peerClassLoadingEnabled() default true;
    String localAddress() default "";
    String ipDiscoveryRange() default "";
    boolean createIfNotExists() default true;
}
