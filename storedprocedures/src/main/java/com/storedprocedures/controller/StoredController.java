package com.storedprocedures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.storedprocedures.modelo.InputData;
import com.storedprocedures.modelo.OutputData;
import com.storedprocedures.services.StoredService;

@RestController
public class StoredController {
	@Autowired
	@Qualifier("storedservice")
	private StoredService storedService;

	@RequestMapping(value = "/executestored", method = RequestMethod.POST)
	@ResponseBody
	public OutputData alta(@RequestBody InputData input) {
		return storedService.execute(input);
	}
}
