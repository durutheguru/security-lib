package com.julianduru.security;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

/**
 * created by julian
 */
@SpringBootTest(
    classes = {
        SecurityLibAutoConfiguration.class,
    }
)
@EnableAutoConfiguration
@EnableJpaRepositories(
    basePackages = {
        "com.julianduru.security.repository"
    }
)
public class ContextLoadingTest {


    @Test
    public void testContextLoads() {
        System.out.println("Context Loaded");
    }

}
