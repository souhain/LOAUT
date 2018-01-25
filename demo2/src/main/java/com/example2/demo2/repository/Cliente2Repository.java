package com.example2.demo2.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example2.demo2.model.Cliente2;

@Repository("cliente2Repository") 
	
public interface Cliente2Repository extends PagingAndSortingRepository<Cliente2, Integer> {

	
}
