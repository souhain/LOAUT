package com.storedprocedures.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.storedprocedures.modelo.Cliente2;

@RepositoryRestResource(collectionResourceRel = "cliente2", path="cliente2")
public interface ClientRepository extends PagingAndSortingRepository<Cliente2, Long>{ 
	
}
