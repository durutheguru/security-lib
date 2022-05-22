package com.julianduru.security.modules;


import com.julianduru.security.api.UserAuthMapping;
import com.julianduru.security.entity.UserAuthority;
import com.julianduru.security.repository.UserAuthorityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * created by julian
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserAuthorityServiceImpl implements UserAuthorityService {


    private final UserAuthorityRepository userAuthorityRepository;


    @Override
    public UserAuthority save(UserAuthMapping authMapping) {
        var userAuthority = userAuthorityRepository
            .findByUsernameAndAuthorityId(
                authMapping.getUsername(), authMapping.getAuthority()
            )
            .orElse(new UserAuthority());
        
        userAuthority.setUsername(authMapping.getUsername());
        userAuthority.setAuthorityId(authMapping.getAuthority());
        userAuthority.setFileReferences(authMapping.getFileReferences());

        return userAuthorityRepository.save(userAuthority);
    }


    public void removeUserAuthority(String username, String authority) {
        userAuthorityRepository.deleteByUsernameAndAuthorityId(
            username, authority
        );
    }

    @Override
    public List<UserAuthority> fetchAllByAuthorityId(String authorityId) throws Exception {
        if (StringUtils.isEmpty(authorityId)){
            log.info("empty value was passed as authority id");
            throw new Exception("Authority can not be empty");
        }
        return userAuthorityRepository.findAllByAuthorityId(authorityId).orElseThrow();
    }


    @Override
    public List<UserAuthority> getByUser(String username) {
        return userAuthorityRepository.findByUsername(username);
    }


    @Override
    public boolean isUserAuthorized(String username, String authority) {
        return userAuthorityRepository.existsByUsernameAndAuthorityId(username, authority);
    }


    @Override
    public boolean isUserAuthorized(String username, String authority, boolean errorIfNot) {
        var authorized = userAuthorityRepository.existsByUsernameAndAuthorityId(username, authority);

        if (!errorIfNot || authorized) {
            return authorized;
        }
        else {
            throw new SecurityException(
                String.format("User '%s' not authorized with '%s'", username, authority)
            );
        }
    }

    @Override
    public boolean usersAuthorized(Set<String> usernames, String authority, boolean errorIfNot) {
        var authorized = true;

        for (String username : usernames) {
            authorized &= isUserAuthorized(username, authority, errorIfNot);
        }

        return authorized;
    }


}




