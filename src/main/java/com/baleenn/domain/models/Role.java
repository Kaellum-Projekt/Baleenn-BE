package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Role extends Audit<Long> {
	@Id
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "role_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@Column(nullable = false)
	private String name;	
	
	@ManyToMany
	@JoinTable(
	  name = "role_permission", 
	  joinColumns = @JoinColumn(name = "role_id"), 
	  inverseJoinColumns = @JoinColumn(name = "permission_id"))
	Set<Permission> permissions;

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
