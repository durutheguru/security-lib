package com.julianduru.security.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * created by julian
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthId {

    @Column(length = 100)
    public String authUsername;


    @Column(length = 100)
    public String authRoleId;


}

