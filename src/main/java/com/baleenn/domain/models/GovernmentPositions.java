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

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class GovernmentPositions extends Audit<Long>{
	
	@Id
    @SequenceGenerator(name = "govpositions_sequence", sequenceName = "govpositions_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "govpositions_sequence")
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
	
	@Column(nullable = false)
	private String countryJurisdiction;	
	
	@Column(nullable = true)
	private String branch;
	
	@Column(nullable = false)
	private String activities;

	@Override
 	public boolean isNew() {
         return this.getId() == null;
     }

}
