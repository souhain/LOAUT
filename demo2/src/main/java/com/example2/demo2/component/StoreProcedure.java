package com.example2.demo2.component;

import java.math.BigDecimal;
import java.sql.*;

import org.springframework.stereotype.Component;

import com.example2.demo2.model.ResultStoreP;

@Component("storeProcedure")
public class StoreProcedure {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://172.22.25.116:3306/mydb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	
	
	public ResultStoreP callStoredProcedure(String name, String address, String email, String phone, BigDecimal saldo ) throws SQLException {
		
		ResultStoreP resultStoreP = null;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		String SPFinal1 = "{call SPFinal1(?, ?, ?, ?, ?, ?, ?, ?)}";

		try {
			dbConnection = getDBConnection();
			callableStatement = dbConnection.prepareCall(SPFinal1);

			callableStatement.setString(1, name );
			callableStatement.setString(2, address );
			callableStatement.setString(3, email );
			callableStatement.setString(4, phone );
			callableStatement.setBigDecimal(5, saldo);
			
			
			callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(8, java.sql.Types.DECIMAL);

			// execute SPFinal1 store procedure
			callableStatement.executeUpdate();

			int idClienteOut = callableStatement.getInt(6);
			int idCuentaOut = callableStatement.getInt(7);
			BigDecimal saldoOut = callableStatement.getBigDecimal(8);

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
	
	private Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return dbConnection;
	}

}
