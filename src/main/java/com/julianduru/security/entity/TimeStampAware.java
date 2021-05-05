package com.julianduru.security.entity;


import java.time.ZonedDateTime;

/**
 * created by julian
 */
public interface TimeStampAware {


    ZonedDateTime getTimeAdded();


    ZonedDateTime getTimeUpdated();


}
