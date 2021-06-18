package com.baleenn.dto.request;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rapha
 *
 */
@Data
@NoArgsConstructor
public class ClientRequestDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean hasHadDiffName;
    private String anotherUsedName;
    private String fullAddress;
    private String email_address;
    private LocalDate dob;  
    private int professionId;
    private int maritalCode;
    private int clientType;
    private int statusId;
    private String landline;
    private String cellphone;
    private String workphone;
    private String citzenships;
    private String countryResidence;
    private String countryBirth;
    private String cityOfBirth;
    private String eyeColour;
    private int heightInCm;
    private boolean everAppliedCanadianVisa;
    private LocalDate dateFirstEntry;
    private String cityOfEntry;
    private String canadianCicProgram;
    private LocalDate dateLastEntry;
    private String cityLastEntry;
    private String LivedInAnotherCountry;
    private String countriesLivedIn;
    private boolean hasEverHadVisaDenied;
    private String deniedVisaCountries;
    private String deniedVisaCountriesReason;
    private boolean hasEverHadLeaveCountry;
    private String requestedCountries;
    private String requestedCountriesReason;
    private boolean relativePermanentInCanada;
    private String statutoryQuestion;
	private String createdBy;
	//@JsonIgnore
	private LocalDateTime dateCreated;
    private String lastUpdatedBy;
    //@JsonIgnore
    private LocalDateTime lastUpdatedDate;
	
}
