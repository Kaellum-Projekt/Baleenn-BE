package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;

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

//TODO: Ask Marcus what is this table for

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PersonalHistory extends Audit<Long>{
	
	@Id
    @SequenceGenerator(name = "personal_history_sequence", sequenceName = "personal_history_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "personal_history_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Client client;
	
	@Column(nullable = false)
	private LocalDate fromDate;
	
	@Column(nullable = false)
	private LocalDate toDate;
	
	@Column(nullable = true)
	private String activity;
	
	@Column(nullable = true)
	private String country;
	
	@Column(nullable = true)
	private String city;
	
	@Column(nullable = true)
	private String status;
	
	@Column(nullable = true)
	private String companyName;

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
