package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class UserBaleenn extends Audit<Long> {
	
	@Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String middleName;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(referencedColumnName = "id", unique = false, updatable = false, insertable = false, nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Role role;
	
	@Column(nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "userBaleenn")
	private UserBaleennProcesses userBaleennProcesses;
	

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
