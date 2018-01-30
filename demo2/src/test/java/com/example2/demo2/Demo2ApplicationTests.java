package com.example2.demo2;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example2.demo2.component.StoreProcedure;
import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Cuenta2;
import com.example2.demo2.model.ResultStoreP;
import com.example2.demo2.repository.Cliente2Repository;
import com.example2.demo2.repository.Cuenta2Repository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

	@Autowired
	@Qualifier("storeProcedure")
	StoreProcedure storeProcedure;

	@Autowired
	@Qualifier("cliente2Repository")
	Cliente2Repository clienteRepository;

	@Autowired
	@Qualifier("cuenta2Repository")
	Cuenta2Repository cuentaRepository;
	
	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void saldoTest() throws SQLException {
		System.out.println("Test de agregar saldo");
		ResultStoreP resultStoreP = storeProcedure.callStoredProcedure(
				"Javie", 
				"Emilio  25", 
				"javarmgar@.com", 
				"3", 
				new BigDecimal( 70.0),
				"ejecutive_Javie@.com");
		
		
		cuentaRepository.delete(resultStoreP.getIdCuenta() );
		clienteRepository.delete(resultStoreP.getIdCliente());

		assertEquals("Error en el saldo", (new BigDecimal( 70.0 ) ), (resultStoreP.getSaldo() ) ) ;
		
	}
	
	
	@Test
	public void nameTest() throws SQLException {
		System.out.println("Test nombre  ");
		
		ResultStoreP resultStoreP = storeProcedure.callStoredProcedure(
				"Javie", 
				"Emilio  25", 
				"javarmgar@.com", 
				"3", 
				new BigDecimal( 70.0),
				"ejecutive_Javie@.com");
	
		Cliente2 cl = clienteRepository.findOne(new Integer( resultStoreP.getIdCliente()));
		Cuenta2 cu=cuentaRepository.findOne(resultStoreP.getIdCuenta());
		
		
		cuentaRepository.delete(cu);
		clienteRepository.delete(cl);

		assertEquals("Error en el nombre", "Javier" , cl.getName());
		
		
	}
	
	
	@Test
	public void addressTest() throws SQLException {
		System.out.println("Test de address ");
		
		ResultStoreP resultStoreP = storeProcedure.callStoredProcedure(
				"Javie", 
				"Emilio  25", 
				"javarmgar@.com", 
				"3", 
				new BigDecimal( 70.0),
				"ejecutive_Javie@.com");
	
		Cliente2 cl = clienteRepository.findOne(new Integer( resultStoreP.getIdCliente()));
		
		cuentaRepository.delete(new Integer(resultStoreP.getIdCuenta() ) );
		clienteRepository.delete(new Integer(resultStoreP.getIdCliente() ));
		
		assertEquals("Error en la direccion", "Emilio  25" , cl.getAddress());
		
	}
	

	@Test
	public void emailTest() throws SQLException {
		System.out.println("Test de email");
		
		ResultStoreP resultStoreP = storeProcedure.callStoredProcedure(
				"Javie", 
				"Emilio  25", 
				"javarmgar@.com", 
				"3", 
				new BigDecimal( 70.0),
				"ejecutive_Javie@.com");
	
		Cliente2 cl = clienteRepository.findOne(new Integer( resultStoreP.getIdCliente()));
		
		
		
		cuentaRepository.delete(new Integer(resultStoreP.getIdCuenta() ) );
		clienteRepository.delete(new Integer(resultStoreP.getIdCliente() ));
	//	System.out.println(cl);
		assertEquals("Error en el correo", "javarmgar@gmail.com" , cl.getEmail());
	
	}
	
	
	@Test
	public void phoneTest() throws SQLException {
		System.out.println("Test de phone");
		
		ResultStoreP resultStoreP = storeProcedure.callStoredProcedure(
				"Javie", 
				"Emilio  25", 
				"javarmgar@.com", 
				"3", 
				new BigDecimal( 70.0),
				"ejecutive_Javie@.com");
	
		Cliente2 cl = clienteRepository.findOne(new Integer( resultStoreP.getIdCliente()));
		
		
		
		cuentaRepository.delete(new Integer(resultStoreP.getIdCuenta() ) );
		clienteRepository.delete(new Integer(resultStoreP.getIdCliente() ));
		assertEquals("Error en el telefono", "3493284879" , cl.getPhone());

	}
	

	@Test
	public void ejecutiveTest() throws SQLException {
		System.out.println("Test de phone");
		
		ResultStoreP resultStoreP = storeProcedure.callStoredProcedure(
				"Javie", 
				"Emilio  25", 
				"javarmgar@.com", 
				"3", 
				new BigDecimal( 70.0),
				"ejecutive_Javie@.com");
	
		Cliente2 cl = clienteRepository.findOne(new Integer( resultStoreP.getIdCliente()));
		Cuenta2 cu=cuentaRepository.findOne(resultStoreP.getIdCuenta());
		
		
		
		cuentaRepository.delete(new Integer(resultStoreP.getIdCuenta() ) );
		clienteRepository.delete(new Integer(resultStoreP.getIdCliente() ));
		assertEquals("Error en el ejecutivo", "ejecutive_Javie@.com" , cu.getEjecutive_email());

	}

}
