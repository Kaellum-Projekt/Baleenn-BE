package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class UserBaleennProcesses extends Audit<Long>{
	
	@Id
    @SequenceGenerator(name = "user_baleenn_processes_sequence", sequenceName = "user_baleenn_processes_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_baleenn_processes_sequence")
    @Column(updatable = false) 
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique=true, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(name="FK_user_baleenn_processes_user_baleenn"))
	private UserBaleenn userBaleenn;
	
	@OneToMany(mappedBy="userBaleennProcesses")
	private Set<Process> processes;
	
	@Override
	public boolean isNew() {
		return this.getId() == null;
	}

}
