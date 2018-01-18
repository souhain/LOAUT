package com.acme.DemoBoot.repository;

import org.springframework.data.repository.CrudRepository;
import com.acme.DemoBoot.modelo.User;


public interface UserRepository extends CrudRepository<User, Long>{
	
	
	User findByUsername(String name);
	 
}