package com.example2.demo2.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example2.demo2.component.StoreProcedure;
import com.example2.demo2.model.ResultStoreP;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {
	
	@Autowired
	private MockMvc mockServ;
	
	@MockBean
	private StoreProcedure mockStoreProcedure;
	
	ObjectMapper mapper = new ObjectMapper();
	
	String agregarClienteJson = "{\"name\":\"Javier armenta\","
			+ "\"address\":\"hidalgo\","
			+ "\"email\":\"javarmgar@gmail.com\","
			+ "\"phone\":\"24353451\","
			+ "\"saldo\":\"43240.11\","
			+ "\"ejecutive_email\":\"javo_ejec@gmail.com\"}";
	

	@Test
	public void altaServicioStore() throws Exception{
		
		ResultStoreP resultStoreP = new ResultStoreP(100, new BigDecimal(1000.00), 40);
		
		Mockito.when( mockStoreProcedure.
				
				callStoredProcedure(
						Mockito.anyString(), 
						Mockito.anyString(), 
						Mockito.anyString(), 
						Mockito.anyString(), 
						new BigDecimal ( Mockito.anyDouble() ),
						Mockito.anyString()
						)
				).thenReturn(resultStoreP);
			
		RequestBuilder reqMock = MockMvcRequestBuilders
				.post("/cliente2/agregarCliente")
				.accept(MediaType.APPLICATION_JSON)
				.content( agregarClienteJson )
				.contentType(MediaType.APPLICATION_JSON);
		
		
		MvcResult resultadoMock = mockServ.perform(reqMock)
				.andReturn();
		MockHttpServletResponse response = resultadoMock.getResponse();
		
		
		
		String jsonInString = response.getContentAsString();
		
		ResultStoreP outputReal = mapper.readValue(jsonInString, ResultStoreP.class);
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(resultStoreP.getIdCliente() , outputReal.getIdCliente() );
		assertEquals(resultStoreP.getIdCuenta() , outputReal.getIdCuenta() );
		assertEquals(resultStoreP.getSaldo() , outputReal.getSaldo() );
		
	}
}
