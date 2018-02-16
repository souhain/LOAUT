package com.storedprocedures.services;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import com.storedprocedures.modelo.InputData;
import com.storedprocedures.modelo.OutputData;

@Service("storedservice")
public class StoredService extends StoredProcedure{
	
	private static final String SPROC_NAME = "SPFinal1";
	
	@Autowired
	StoredService(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		declareParameter(new SqlParameter("name", Types.VARCHAR));
		declareParameter(new SqlParameter("addess", Types.VARCHAR));
		declareParameter(new SqlParameter("email", Types.VARCHAR));
		declareParameter(new SqlParameter("phone", Types.VARCHAR));
		declareParameter(new SqlParameter("saldo", Types.DECIMAL));
		declareParameter(new SqlParameter("ejecutiveEmail", Types.VARCHAR));
		
		
		declareParameter(new SqlOutParameter("idClienteOut", Types.INTEGER));
		declareParameter(new SqlOutParameter("idCuentaOut", Types.INTEGER));
	    declareParameter(new SqlOutParameter("saldoOut", Types.DECIMAL));
	    compile();
	}
	
	public OutputData execute(InputData input) {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("name", input.getName());
		inParams.put("addess", input.getAddress());
		inParams.put("email", input.getEmail());
		inParams.put("phone", input.getPhone());
		inParams.put("saldo", input.getAmount());
		inParams.put("ejecutiveEmail", input.getExcecutive());

		Map<String, Object> out = super.execute(inParams);
		out.put("idClienteOut", String.format("%08d", out.get("idClienteOut")));
		return new OutputData(out);
	}
}
