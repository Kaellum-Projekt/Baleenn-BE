package com.baleenn.domain.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Process extends Audit<Long>{
	
	@Id
    @SequenceGenerator(name = "process_sequence", sequenceName = "process_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "process_sequence")
    @Column(updatable = false) 
	private Long id;
	
	@Column(nullable = false)
	private Integer processTypeId;
	
	@Column(nullable = false)
	private String processStatus;
	
	@Column(nullable = false)
	private Integer processFormId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", unique = false, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(name="FK_process_client"))
	private Client client;
	
	@Column(nullable = true)
	private String finalized;
	
	@Column(nullable = true)
	private String description;
	
    @OneToMany(mappedBy="process")
    private Set<Documents> documents;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", unique=true, updatable = true, insertable = true, 
    nullable=true, foreignKey = @ForeignKey(name="FK_process_user_baleenn_processes"))
    private UserBaleennProcesses userBaleennProcesses;

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}
    

}
