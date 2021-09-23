package com.webproject.web_miniproject.domain.common;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseTimeEntity {
 
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // protected Long id;
    
    @CreatedDate
    @Column(name = "create_date",updatable = false)
    protected LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "update_date")
    protected LocalDateTime updatedAt;

    @Column(name = "delete_date", updatable = false)
    protected LocalDateTime deletedAt;

    

}
