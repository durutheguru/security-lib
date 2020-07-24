package com.julianduru.security;


import com.julianduru.security.entity.UserAuthId;
import com.julianduru.security.exception.NoAuthenticatedUserException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

/**
 * created by julian
 */
public class Auth {


    public static boolean hasContext() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }


    public static Authentication getContext() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


    public static void setContext(Authentication auth) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);

        SecurityContextHolder.setContext(context);
    }


    public static Optional<UserAuthId> getUserAuthId() {
        Authentication authentication = getContext();
        if (authentication == null) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        String user = principal instanceof User ? ((User)principal).getUsername() : principal.toString();
        final String[] roleId = {""};

        authentication.getAuthorities()
                .stream()
                .findFirst()
                .ifPresent(a -> roleId[0] = a.getAuthority());

        UserAuthId authId = new UserAuthId(user, roleId[0]);
        return Optional.of(authId);
    }


    public static UserAuthId getUserAuthId(boolean errorIfMissing) throws NoAuthenticatedUserException {
        Optional<UserAuthId> authId = getUserAuthId();
        if (!authId.isPresent()) {
            if (errorIfMissing) {
                throw new NoAuthenticatedUserException("User details could not be found in Security Context");
            }
            else {
                return null;
            }
        }

        return authId.get();
    }


}

