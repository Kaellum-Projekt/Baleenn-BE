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
public class Documents extends Audit<Long> {
	
	@Id
    @SequenceGenerator(name = "documents_sequence", sequenceName = "documents_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "documents_sequence")
    @Column(updatable = false) 
	private Long id;
	
	
	@Column(nullable = false)
	private String fileName;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", unique=true, updatable = true, insertable = true, 
                nullable=true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Process process;
	

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}	

}
