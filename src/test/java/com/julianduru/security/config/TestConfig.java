package com.julianduru.security.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * created by julian
 */
@TestConfiguration
@EnableJpaRepositories(
    basePackages = "com.julianduru.security"
)
@EnableAutoConfiguration
public class TestConfig {

}
