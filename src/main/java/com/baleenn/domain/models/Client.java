/**
 * 
 */
package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;

import javax.persistence.*;

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
public class Client extends Audit<Long> {
     @Id
     @SequenceGenerator(name = "client_sequence", sequenceName = "client_sequence",allocationSize = 1)
     @GeneratedValue(strategy = SEQUENCE, generator = "client_sequence")
     @Column(updatable = false) 
	 private Long id;
     
     @Column(nullable = false)
     private String firstName;
     
     @Column(nullable = true)
     private String middleName;
     
     @Column(nullable = false)
     private String lastName;

     @Column(nullable = false, columnDefinition = "boolean default false")
     private boolean hasHadDiffName;
     
     @Column(nullable = true)
     private String anotherUsedName;
     
     @Column(nullable = false)
     private String fullAddress;
     
     @Column(nullable = false, unique = true)
     private String emailAddress;
     
     @Column(nullable = false)
     private LocalDate dob;  
     
     @Column(nullable = false)
     private int professionId;
     
     @Column(nullable = false)
     private int maritalCode;
     
     @Column(nullable = false)
     private int clientType;
     
     @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(referencedColumnName = "id", unique=true, updatable = true, insertable = true, 
                 nullable=true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
     private SpouseInformation spouseInformation;
     
     @Column(nullable = false)
     private int statusId;
     
     @Column(nullable = true)
     private String landline;
     
     @Column(nullable = true)
     private String cellphone;
	 
     @Column(nullable = true)
     private String workphone;
     
     @Column(nullable = false)
     private String citzenships;
     
     @Column(nullable = false)
     private String countryResidence;
     
     @Column(nullable = false)
     private String countryBirth;
     
     @Column(nullable = false)
     private String cityOfBirth;
     
     @Column(nullable = true)
     private String eyeColour;
    
     @Column(nullable = false)
     private int heightInCm;

     @Column(nullable = false)
     private boolean everAppliedCanadianVisa;
     
     @Column(nullable = true)
     private LocalDate dateFirstEntry;
     
     @Column(nullable = true)
     private String cityOfEntry;
     
     @Column(nullable = true)
     private String canadianCicProgram;
     
     @Column(nullable = true)
     private LocalDate dateLastEntry;
     
     @Column(nullable = true)
     private String cityLastEntry;
     
     @Column(nullable = true)
     private String LivedInAnotherCountry;
     
     @Column(nullable = true)
     private String countriesLivedIn;
     
     @Column(nullable = false)
     private boolean hasEverHadVisaDenied;
     
     @Column(nullable = false)
     private String deniedVisaCountries;
     
     @Column(nullable = false)
     private String deniedVisaCountriesReason;
     
     @Column(nullable = false)
     private boolean hasEverHadLeaveCountry;
     
     @Column(nullable = true)
     private String requestedCountries;
     
     @Column(nullable = true)
     private String requestedCountriesReason;
     
     @Column(nullable = false)
     private boolean relativePermanentInCanada;
     
     @Column(nullable = true)
     private String statutoryQuestion;
     
 	@Override
 	public boolean isNew() {
         return this.getId() == null;
     }

}
