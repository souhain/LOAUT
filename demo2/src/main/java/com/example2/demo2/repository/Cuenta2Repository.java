package com.example2.demo2.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Cuenta2;

@Repository("cuenta2Repository")
public interface Cuenta2Repository extends PagingAndSortingRepository<Cuenta2, Integer>{

	
}
