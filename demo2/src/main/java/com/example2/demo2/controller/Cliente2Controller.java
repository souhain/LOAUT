package com.example2.demo2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Container;
import com.example2.demo2.model.Cuenta2;
import com.example2.demo2.model.ResultStoreP;
import com.example2.demo2.service.StoreProcedureService;

@Controller
@RequestMapping("/cliente2")
public class Cliente2Controller {
	
	private static final String CLIENTES_VIEW = "form";
	private static final String RESULT_VIEW= "result";

	private static final Log LOGGER=LogFactory.getLog(Cliente2Controller.class);
	@Autowired
	@Qualifier("StoreProcedureServiceImpl")
	private StoreProcedureService storeProcedureServiceImpl;
	
	@GetMapping("/showForm")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView(CLIENTES_VIEW);
		mav.addObject("container_form", new Container());
		return mav;
	}
	

	
	@RequestMapping(value = "/agregarCliente", method = RequestMethod.POST)
	@ResponseBody
	public ResultStoreP agregarCliente(@RequestBody Container c) {
		
		System.out.println(c);

		ResultStoreP resultStoreP = storeProcedureServiceImpl.insertarCliente(c);
		return resultStoreP ;
	}
	
	
}


