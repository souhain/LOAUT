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
import com.example2.demo2.model.Container;
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
	public ResultStoreP insertarCliente(Container c) {
		
		LOGGER.info("Method insertarCliente()");
		ResultStoreP resultStoreP = null;
		try {
			resultStoreP = storeProcedure.callStoredProcedure(
					c.getName(),
					c.getAddress(),
					c.getEmail(),
					c.getPhone(),
					c.getSaldo(),
					c.getEjecutive_email()
					);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultStoreP;
	}

}
