package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Profession extends Audit<Long>{
	
    @Id
    @SequenceGenerator(name = "profession_sequence", sequenceName = "profession_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "profession_sequence")
    @Column(updatable = false) 
	private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private char NOC;   

    @Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
