package com.baleenn.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.baleenn.domain.models.Client;

@Repository
public interface ClientRepository extends 
								JpaRepository<Client, Long>, 
								//QuerydslPredicateExecutor<Client>, 
								JpaSpecificationExecutor<Client>{

}
