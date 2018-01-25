package com.example2.demo2.service;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Cuenta2;
import com.example2.demo2.model.ResultStoreP;

public interface StoreProcedureService {
	
	public abstract ResultStoreP insertarCliente(Cliente2 cliente2, Cuenta2 cuenta2);
	
}
