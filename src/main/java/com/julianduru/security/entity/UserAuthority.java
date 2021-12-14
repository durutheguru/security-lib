package com.julianduru.security.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * created by julian
 */
@Data
@Entity
@Table(name = "sec_user_authority")
public class UserAuthority extends BaseEntity {


    @Column(nullable = false, length = 200)
    private String username;


    @Column(nullable = false, length = 250)
    private String authorityId;


    @ElementCollection
    private List<String> fileReferences;


}

