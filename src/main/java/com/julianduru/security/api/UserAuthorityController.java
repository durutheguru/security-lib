package com.julianduru.security.api;


import com.julianduru.security.modules.UserAuthorityService;
import com.julianduru.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by julian
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(UserAuthorityController.PATH)
public class UserAuthorityController {
    
    
    public static final String PATH = "/api/v1/user_auth_map";


    private final UserAuthorityService userAuthorityService;

    

    @GetMapping
    public List<UserAuthorityDTO> getByUser(
        @RequestParam("userId") String userId
    ) {
        var authorities = userAuthorityService.getByUser(userId);
        return MapperUtil.map(authorities, UserAuthorityDTO.class);
    }


    @GetMapping("/authorized")
    public boolean authorized(
        @RequestParam("userId") String userId,
        @RequestParam("authorityId") String authorityId
    ) {
        return userAuthorityService.isUserAuthorized(userId, authorityId);
    }


}



