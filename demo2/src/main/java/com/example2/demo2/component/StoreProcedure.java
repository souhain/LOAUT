package com.example2.demo2.component;

import java.math.BigDecimal;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example2.demo2.model.ResultStoreP;

@Component("storeProcedure")
public class StoreProcedure {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	
	
	public ResultStoreP callStoredProcedure(String name, String address, String email, String phone, BigDecimal saldo,String ejecutive_email ) throws SQLException {
		
		ResultStoreP resultStoreP = null;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		String SPFinal1 = "{call SPFinal1(?, ?, ?, ?, ?, ?, ?, ?,?)}";

		try {
			dbConnection =jdbcTemplate.getDataSource().getConnection();
			callableStatement = dbConnection.prepareCall(SPFinal1);

			callableStatement.setString(1, name );
			callableStatement.setString(2, address );
			callableStatement.setString(3, email );
			callableStatement.setString(4, phone );
			callableStatement.setBigDecimal(5, saldo);
			callableStatement.setString(6, ejecutive_email);
			
			
			callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(9, java.sql.Types.DECIMAL);

			// execute SPFinal1 store procedure
			callableStatement.executeUpdate();

			int idClienteOut = callableStatement.getInt(7);
			int idCuentaOut = callableStatement.getInt(8);
			BigDecimal saldoOut = callableStatement.getBigDecimal(9);

			System.out.println("idCliente: " + idClienteOut);
			System.out.println("idCuenta : " + idCuentaOut);
			System.out.println("saldo : " + saldoOut);
			
			resultStoreP = new ResultStoreP(idClienteOut, saldoOut, idCuentaOut);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
		return resultStoreP; 
	}
	
	

}
