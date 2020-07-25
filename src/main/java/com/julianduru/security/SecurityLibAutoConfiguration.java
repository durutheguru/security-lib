package com.julianduru.security;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * created by julian
 */
@Configuration
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
