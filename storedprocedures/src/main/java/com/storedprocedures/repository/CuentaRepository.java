package com.storedprocedures.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.storedprocedures.modelo.Cuenta2;

@RepositoryRestResource(collectionResourceRel = "cuenta2", path="cuenta2")
public interface CuentaRepository extends PagingAndSortingRepository<Cuenta2, Long>{ 
	
}