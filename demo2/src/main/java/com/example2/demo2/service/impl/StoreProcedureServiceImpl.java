package com.example2.demo2.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example2.demo2.component.StoreProcedure;
import com.example2.demo2.controller.Cliente2Controller;
import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Cuenta2;
import com.example2.demo2.model.ResultStoreP;
import com.example2.demo2.repository.Cliente2Repository;
import com.example2.demo2.repository.Cuenta2Repository;
import com.example2.demo2.service.StoreProcedureService;

@Service("StoreProcedureServiceImpl")

public class StoreProcedureServiceImpl implements StoreProcedureService {

	private static final Log LOGGER=LogFactory.getLog(StoreProcedureServiceImpl.class);

	@Autowired
	@Qualifier("storeProcedure")
	private StoreProcedure storeProcedure;
	
	

	
	
	@Override
	public ResultStoreP insertarCliente(Cliente2 cliente2, Cuenta2 cuenta2) {
		LOGGER.info("Method insertarCliente()");
		ResultStoreP resultStoreP = null;
		try {
			resultStoreP = storeProcedure.callStoredProcedure(
					cliente2.getName(),
					cliente2.getAddress(),
					cliente2.getEmail(),
					cliente2.getPhone(),
					cuenta2.getSaldo()
					);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultStoreP;
	}

}
