package com.julianduru.security.modules;


import com.julianduru.security.Auth;
import com.julianduru.security.api.UserAuthMapping;
import com.julianduru.security.entity.UserAuthority;

import java.util.List;
import java.util.Set;

/**
 * created by julian
 */
public interface UserAuthorityService {


    UserAuthority save(UserAuthMapping authMapping);


    List<UserAuthority> getByUser(String username);


    default boolean isUserAuthorized(String username, String authority) {
        return isUserAuthorized(username, authority, false);
    }


    default boolean isUserAuthorized(String authority) {
        return isUserAuthorized(
            Auth.getUserAuthId(true).authUsername,
            authority, true
        );
    }


    boolean isUserAuthorized(String username, String authority, boolean errorIfNot);


    default boolean usersAuthorized(Set<String> usernames, String authority) {
        return this.usersAuthorized(usernames, authority, false);
    }


    boolean usersAuthorized(Set<String> usernames, String authority, boolean errorIfNot);


    void removeUserAuthority(String username, String authority);


    List<UserAuthority> fetchAllByAuthorityId(String authorityId) throws Exception;


}


