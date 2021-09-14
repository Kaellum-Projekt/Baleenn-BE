package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Address extends Audit<Long> {
    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "address_sequence")
    @Column(updatable = false) 
	private Long id;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String apartmentNumber;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String province;
    
    @Column(nullable = false)
    private String country;
    
    @Column(nullable = false)
    private String zipCode;
    
    @Column(nullable = false)
    @Min(1) @Max(6)
    private int typeAddress;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", unique=false, updatable = true, insertable = true, nullable = true, foreignKey = @ForeignKey(name="FK_client_address"))
    private Client client;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", unique=false, updatable = true, insertable = true, nullable = true, foreignKey = @ForeignKey(name="FK_family_information_address"))
    private FamilyInformation familyInformation;

    @Override
	public boolean isNew() {
		return this.getId() == null;
	}
}
