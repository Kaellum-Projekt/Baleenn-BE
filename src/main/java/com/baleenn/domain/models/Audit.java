package com.baleenn.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Raphael Cremasco
 *
 */
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Audit<ID> implements Persistable<ID>{
	    @Column
	    @CreatedBy
	    private String createdBy;
	    
	    @Column(columnDefinition = "timestamp with time zone")
	    @CreatedDate
	    private LocalDateTime createdDate;
	    
	    @Column
	    @LastModifiedBy
	    private String lastModifiedBy;
	    
	    @Column(columnDefinition = "timestamp with time zone")
	    @LastModifiedDate
	    private LocalDateTime lastModifiedDate;
}
