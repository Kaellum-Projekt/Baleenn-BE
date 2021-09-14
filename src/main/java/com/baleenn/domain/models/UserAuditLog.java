package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserAuditLog extends Audit<Long>{
	
	@Id
    @SequenceGenerator(name = "user_audit_sequence", sequenceName = "user_audit_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_audit_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private UserBaleenn userBaleenn;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Process process;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Client client;
	
	@Column(nullable = false)
	private String changeType;
	
	@Column(nullable = false)
	private String tableName;
	
	@Column(nullable = false)
	private String fieldName;
	
	@Column(nullable = false)
	private String originalValue;
	
	@Column(nullable = false)
	private String modifiedValue;

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}
}
