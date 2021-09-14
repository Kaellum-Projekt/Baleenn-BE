package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Work extends Audit<Long>{
	
	@Id
    @SequenceGenerator(name = "work_sequence", sequenceName = "work_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "work_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable = true, foreignKey = @ForeignKey(name="FK_work_client"))
	private Client client;
	
	@Column(nullable = false)
	private LocalDate fromDate;
	
	@Column(nullable = false)
	private LocalDate toDate;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private String jobTitle;
	
	@Column(nullable = true)
	private String website;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", unique=true, updatable = true, insertable = true, 
                nullable=true, foreignKey = @ForeignKey(name="FK_work_address"))
	private Address address;
	
	@Column(nullable = false)
	private Boolean isSelfEmployed;
	
	@Column(nullable = false)
	private String articlesIncorp;
	
	@Column(nullable = false)
	private Integer hoursPerWeek;
	
	@Column(nullable = false)
	private String duties;

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
