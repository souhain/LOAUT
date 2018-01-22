package com.example2.demo2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example2.demo2.model.Cuenta2;

@Repository
public interface Cuenta2Repository extends PagingAndSortingRepository<Cuenta2, Integer>{

}
