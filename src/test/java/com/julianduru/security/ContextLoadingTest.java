package com.julianduru.security;


import com.julianduru.security.config.TestConfig;
import org.junit.jupiter.api.Disabled;
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
        TestConfig.class,
        SecurityLibAutoConfiguration.class,
    }
)
public class ContextLoadingTest {


    @Test
    @Disabled
    public void testContextLoads() {
        System.out.println("Context Loaded");
    }

}
