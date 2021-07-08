package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Raphael Cremasco
 *
 */
@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SpouseInformation extends Audit<Long> {

    @Id
    @SequenceGenerator(name = "spouse_information_sequence", sequenceName = "spouse_information_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "spouse_information_sequence")
    @Column(updatable = false) 
	private Long id;
	
    @OneToOne(mappedBy = "spouseInformation")
    private Client client;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = true)
    private String middleName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = true)
    private String birthFirstName;
    
    @Column(nullable = true)
    private String birthMiddleName;
    
    @Column(nullable = true)
    private String birthLastName;
    
    @Column(nullable = false)
    private LocalDate dateOfRelationship;
    
    @Column(nullable = true)
    private String previousMarriage;

	@Override
	public boolean isNew() {
        return this.getId() == null;
    }
	
}
