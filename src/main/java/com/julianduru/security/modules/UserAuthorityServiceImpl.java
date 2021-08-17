package com.julianduru.security.modules;


import com.julianduru.security.entity.UserAuthority;
import com.julianduru.security.repository.UserAuthorityMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by julian
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserAuthorityServiceImpl implements UserAuthorityService {


    private final UserAuthorityMappingRepository userAuthorityMappingRepository;


    @Override
    public UserAuthority save(String username, String authority) {
        var existingUserAuth = userAuthorityMappingRepository
            .findByUsernameAndAuthorityId(
                username, authority
            );

        if (existingUserAuth.isPresent()) {
            return existingUserAuth.get();
        }

        var userAuthority = new UserAuthority();
        
        userAuthority.setUsername(username);
        userAuthority.setAuthorityId(authority);

        return userAuthorityMappingRepository.save(userAuthority);
    }


    public void removeUserAuthority(String username, String authority) {
        userAuthorityMappingRepository.deleteByUsernameAndAuthorityId(
            username, authority
        );
    }


    @Override
    public List<UserAuthority> getByUser(String username) {
        return userAuthorityMappingRepository.findByUsername(username);
    }


    @Override
    public boolean isUserAuthorized(String username, String authority) {
        return userAuthorityMappingRepository.existsByUsernameAndAuthorityId(username, authority);
    }


    @Override
    public boolean isUserAuthorized(String username, String authority, boolean errorIfNot) {
        var authorized = userAuthorityMappingRepository.existsByUsernameAndAuthorityId(username, authority);

        if (!errorIfNot || authorized) {
            return authorized;
        }
        else {
            throw new SecurityException("User not authorized");
        }
    }


}



