package com.julianduru.security.modules;


import com.julianduru.security.SecurityLibAutoConfiguration;
import com.julianduru.security.api.UserAuthMapping;
import com.julianduru.security.config.TestConfig;
import com.julianduru.security.data.UserAuthorityDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = {
        TestConfig.class,
        SecurityLibAutoConfiguration.class
    }
)
public class UserAuthorityServiceTest {


    @Autowired
    private UserAuthorityDataProvider dataProvider;


    @Autowired
    private UserAuthorityService authorityService;


    @Test
    public void testUserAuthority() throws Exception {
        var mapping = dataProvider.provide();
        var savedAuthority = authorityService.save(
            UserAuthMapping.builder()
                .username(mapping.getUsername())
                .authority(mapping.getAuthorityId())
                .fileReferences(
                    mapping.getFileReferences()
                )
                .build()
        );
        assertThat(savedAuthority).isNotNull();
    }


    @Test
    public void testUserAuthorityAddedMultipleTimes() throws Exception {
        var mapping = dataProvider.provide();

        var mappingEntry = UserAuthMapping.builder()
            .username(mapping.getUsername())
            .authority(mapping.getAuthorityId())
            .fileReferences(
                    mapping.getFileReferences()
            )
            .build();
        var savedAuthority = authorityService.save(
            mappingEntry
        );
        mappingEntry.getFileReferences().remove(0);
        mappingEntry.getFileReferences().addAll(Arrays.asList("234899489OOO", "7498ØOO7274"));
        savedAuthority = authorityService.save(
            mappingEntry
        );

        assertThat(savedAuthority).isNotNull();
    }

}
