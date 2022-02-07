package com.julianduru.security.api;


import lombok.Data;

import java.util.List;

/**
 * created by julian
 */
@Data
public class UserAuthorityDTO {
    
    
    private String authorityId;
    private List<String> fileReferences;

}

