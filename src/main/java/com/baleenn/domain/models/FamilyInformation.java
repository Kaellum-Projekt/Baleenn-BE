package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class FamilyInformation extends Audit<Long>{
	
    @Id
    @SequenceGenerator(name = "family_information_sequence", sequenceName = "family_information_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "family_information_sequence")
    @Column(updatable = false) 
	private Long id;

	@Column(nullable = false)
    @Min(1) @Max(10)
	private int typeRelationship;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(name="FK_family_information_client"))
	private Client client; 
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = true)
	private String middleName;
	
	@OneToMany(mappedBy = "familyInformation")
	private Set<Address> address;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="Invalid email address format")
	private String emailAddress;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@Column(nullable = true)
	private LocalDate deceasedDate;
	
	@Column(nullable = false)
	private String countryOfResidence;
	
	@Column(nullable = false)
	private String countryOfBirth;
	
	@Column(nullable = false)
	private String cityOfBirth;	
    
    @Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
