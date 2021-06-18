/**
 * 
 */
package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Raphael Cremasco
 *
 */
@Entity
@Table(name="client")
@Data
@NoArgsConstructor
public class Client {
     @Id
     @SequenceGenerator(
             name = "client_sequence",
             sequenceName = "client_sequence",
             allocationSize = 1
     )
     @GeneratedValue(
             strategy = SEQUENCE,
             generator = "client_sequence"
     )
     @Column(
             name = "id",
             updatable = false
     ) 
	 private Long id;
     @Column(
             name = "first_name",
             nullable = false
     )
     private String firstName;
     @Column(
             name = "middle_name",
             nullable = true
     )
     private String middleName;
     @Column(
             name = "last_name",
             nullable = false
     )
     private String lastName;
     @Column(
             name = "has_had_diff_name",
             nullable = false,
             columnDefinition = "boolean default false"
     )
     private boolean hasHadDiffName;
     @Column(
             name = "another_used_name",
             nullable = true
     )
     private String anotherUsedName;
     @Column(
             name = "full_address",
             nullable = false
     )
     private String fullAddress;
     @Column(
             name = "email_address",
             nullable = false,
             unique = true
     )
     private String email_address;
     @Column(
             name = "dob",
             nullable = false
     )
     private LocalDate dob;  
     @Column(
             name = "profession_id",
             nullable = false
     )
     private int professionId;
     @Column(
             name = "marital_code",
             nullable = false
     )
     private int maritalCode;
     @Column(
             name = "client_type",
             nullable = false
     )
     private int clientType;
     @Column(
             name = "status_id",
             nullable = false
     )
     private int statusId;
     @Column(
             name = "landline",
             nullable = true
     )
     private String landline;
     @Column(
             name = "cellphone",
             nullable = true
     )
     private String cellphone;
	 
     @Column(
             name = "workphone",
             nullable = true
     )
     private String workphone;
     @Column(
             name = "citzenships",
             nullable = false
     )
     private String citzenships;
     @Column(
             name = "country_residence",
             nullable = false
     )
     private String countryResidence;
     @Column(
             name = "country_birth",
             nullable = false
     )
     private String countryBirth;
     @Column(
             name = "city_of_birth",
             nullable = false
     )
     private String cityOfBirth;
     @Column(
             name = "eye_colour",
             nullable = true
     )
     private String eyeColour;
     @Column(
             name = "height_in_cm",
             nullable = false
     )
     private int heightInCm;
     @Column(
             name = "ever_applied_canadian_visa",
             nullable = false
     )
     private boolean everAppliedCanadianVisa;
     @Column(
             name = "date_first_entry",
             nullable = true
     )
     private LocalDate dateFirstEntry;
     @Column(
             name = "city_of_entry",
             nullable = true
     )
     private String cityOfEntry;
     @Column(
             name = "canadian_cic_program",
             nullable = true
     )
     private String canadianCicProgram;
     @Column(
             name = "date_last_entry",
             nullable = true
     )
     private LocalDate dateLastEntry;
     @Column(
             name = "city_last_entry",
             nullable = true
     )
     private String cityLastEntry;
     @Column(
             name = "lived_in_another_country",
             nullable = true
     )
     private String LivedInAnotherCountry;
     @Column(
             name = "countries_lived_in",
             nullable = true
     )
     private String countriesLivedIn;
     @Column(
             name = "has_ever_had_visa_denied",
             nullable = false
     )
     private boolean hasEverHadVisaDenied;
     @Column(
             name = "denied_visa_countries",
             nullable = false
     )
     private String deniedVisaCountries;
     @Column(
             name = "denied_visa_countries_reason",
             nullable = false
     )
     private String deniedVisaCountriesReason;
     @Column(
             name = "has_ever_had_leave_country",
             nullable = false
     )
     private boolean hasEverHadLeaveCountry;
     @Column(
             name = "requested_countries",
             nullable = true
     )
     private String requestedCountries;
     @Column(
             name = "requested_countries_reason",
             nullable = true
     )
     private String requestedCountriesReason;
     @Column(
             name = "relative_permanent_in_canada",
             nullable = false
     )
     private boolean relativePermanentInCanada;
     @Column(
             name = "statutory_question",
             nullable = true
     )
     private String statutoryQuestion;
     @Column(
             name = "created_by",
             nullable = false
     )
	 private String createdBy;
     @Column(
             name = "date_created",
             nullable = false,
             columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
      )
	 private LocalDateTime dateCreated;
     @Column(
             name = "last_updated_by",
             nullable = false
     )
     private String lastUpdatedBy;
     @Column(
             name = "lastUpdatedDate",
             nullable = false,
             columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
      )
	 private LocalDateTime lastUpdatedDate;

}
