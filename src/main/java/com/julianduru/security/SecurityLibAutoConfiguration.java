package com.julianduru.security;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * created by julian
 */
@Configuration
@EntityScan(
    basePackages = {
        "com.julianduru.security.entity",
    }
)
@ConditionalOnProperty(
    prefix = "code.auto-configure.security",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true
)
@ComponentScan(
    basePackages = {
        "com.julianduru.security",
    }
)
public class SecurityLibAutoConfiguration {

}
