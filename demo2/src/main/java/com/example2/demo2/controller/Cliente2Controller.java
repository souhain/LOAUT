package com.example2.demo2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.model.Cuenta2;
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
		mav.addObject("cliente2_form", new Cliente2());
		mav.addObject("cuenta2_form", new Cuenta2());
		return mav;
	}
	
	@PostMapping("/agregarCliente")
	public ModelAndView agregarCliente(@ModelAttribute("cliente2_form") Cliente2 cliente2_model, @ModelAttribute("cuenta2_form") Cuenta2 cuenta2_model) {

		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		LOGGER.info("Método agregarCliente: \n cliente " + cliente2_model + "\nCuenta" + cuenta2_model);

		storeProcedureServiceImpl.insertarCliente(cliente2_model, cuenta2_model);
		//mav.addObject("cliente2_model", cliente2_model);
		//mav.addObject("cliente2_model", cuenta2_model);
		return mav; 
	}
	
}


