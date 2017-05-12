/**
 * Copyright 2017 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ru.vtb.dbo.configuration;

import org.apache.ignite.Ignite;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = "org.apache.ignite.Ignite")
public class IgniteAutoConfiguration {

    @Bean
    public Ignite ignite() {
        return null;
    }
}
