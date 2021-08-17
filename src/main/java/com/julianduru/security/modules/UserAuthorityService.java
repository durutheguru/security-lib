package com.julianduru.security.modules;


import com.julianduru.security.Auth;
import com.julianduru.security.entity.UserAuthority;

import java.util.List;

/**
 * created by julian
 */
public interface UserAuthorityService {


    UserAuthority save(String username, String authority);


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


    void removeUserAuthority(String username, String authority);


}


