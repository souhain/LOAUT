package com.example2.demo2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.repository.Cliente2Repository;
import com.example2.demo2.service.Cliente2Service;

@Service("cliente2ServiceImpl")

public class Cliente2ServiceImpl implements Cliente2Service {

	@Autowired
	@Qualifier("cliente2Repository")
	private Cliente2Repository cliente2Repository;
	
	@Override
	public Cliente2 insertarCliente(Cliente2 cliente2) {
			
		return cliente2Repository.save(cliente2);
				//insertarCliente(cliente2, address, email, phone);
	}

}
