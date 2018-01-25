package com.example2.demo2.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Cuenta2;
import com.example2.demo2.model.ResultStoreP;
import com.example2.demo2.service.impl.StoreProcedureServiceImpl;

@Repository("StoreProcedureRepository") 


public interface StoreProcedureRepository extends JpaRepository<Cuenta2, Integer>{
	

	@Query(value = "{CALL SPFinal1(:name, :address, :email, :phone, :saldo )}"
			, nativeQuery = true
			)
	public Map<String, Object>  SPFinal1(@Param("name") String name, 
			@Param("address") String address, 
			@Param("email") String email, 
			@Param("phone") String phone, 
			@Param("saldo") BigDecimal saldo);
	
	
	
}
