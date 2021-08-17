package com.julianduru.security.repository;


import com.julianduru.security.entity.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * created by julian
 */
@Repository
public interface UserAuthorityMappingRepository extends JpaRepository<UserAuthority, Long> {


    List<UserAuthority> findByUsername(String username);


    boolean existsByUsernameAndAuthorityId(String username, String authorityId);


    int deleteByUsernameAndAuthorityId(String username, String authorityId);


    Optional<UserAuthority> findByUsernameAndAuthorityId(String username, String authorityId);


}

