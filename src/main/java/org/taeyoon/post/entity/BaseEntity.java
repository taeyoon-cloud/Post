package org.taeyoon.post.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter

public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "createdDate", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name= "modifiedDate")
    private LocalDateTime modifiedDate;
}
