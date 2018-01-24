package com.example2.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example2.demo2.model.Cliente2;
import com.example2.demo2.service.Cliente2Service;

@Controller
@RequestMapping("/cliente2")
public class Cliente2Controller {
	
	private static final String CLIENTES_VIEW = "form";
	private static final String RESULT_VIEW= "result";

	
	@Autowired
	@Qualifier("cliente2ServiceImpl")
	private Cliente2Service cliente2ServiceImpl;
	
	@GetMapping("/showForm")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView(CLIENTES_VIEW);
		mav.addObject("cliente2_form", new Cliente2());
		return mav;
	}
	
	@PostMapping("/agregarCliente")
	public ModelAndView agregarCliente(@ModelAttribute("cliente2_form") Cliente2 cliente2_model) {

		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		cliente2ServiceImpl.insertarCliente(cliente2_model);
		mav.addObject("cliente2_model", cliente2_model);
		return mav; 
	}
	
}


