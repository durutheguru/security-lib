package com.julianduru.security.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianduru.util.entity.TimeStampAware;
import com.julianduru.util.jpa.ZonedDateTimeConverter;
import com.julianduru.util.jpa.ZonedDateTimeStringConverter;
import com.julianduru.util.json.ZonedDateTimeDeserializer;
import com.julianduru.util.json.ZonedDateTimeSerializer;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * created by julian
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseEntity implements TimeStampAware {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, updatable = false)
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @Convert(converter = ZonedDateTimeStringConverter.class)
    private ZonedDateTime timeAdded;


    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @Convert(converter = ZonedDateTimeStringConverter.class)
    private ZonedDateTime timeUpdated;


    @CreatedBy
    @Embedded
    private UserAuthId createdBy;



    @PrePersist
    public void prePersist() {
        timeAdded = ZonedDateTime.now();
    }


    @PreUpdate
    public void preUpdate() {
        timeUpdated = ZonedDateTime.now();
    }


}



