package com.julianduru.security.data;


import com.julianduru.security.entity.UserAuthority;
import com.julianduru.security.repository.UserAuthorityRepository;
import com.julianduru.util.test.JpaDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * created by julian
 */
@Component
@RequiredArgsConstructor
public class UserAuthorityDataProvider implements JpaDataProvider<UserAuthority> {


    private final UserAuthorityRepository userAuthorityRepository;


    @Override
    public JpaRepository<UserAuthority, Long> getRepository() {
        return userAuthorityRepository;
    }


    @Override
    public UserAuthority provide() {
        var authority = new UserAuthority();

        authority.setUsername(faker.internet().emailAddress());
        authority.setAuthorityId(faker.code().isbn10());
        authority.setFileReferences(
            new ArrayList<>(
                Arrays.asList(
                    faker.code().isbn10(false),
                    faker.code().isbn10(false),
                    faker.code().isbn10(false)
                )
            )
        );

        return authority;
    }


}


