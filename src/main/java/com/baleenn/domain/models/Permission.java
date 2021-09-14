package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Permission extends Audit<Long> {
	
	@Id
    @SequenceGenerator(name = "permission_sequence", sequenceName = "permission_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "permission_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer permissionLevel;
	
	@ManyToMany(mappedBy="permissions")
	Set<Role> role;
	
	@Override
	public boolean isNew() {
		return this.getId() == null;
	} 
}
