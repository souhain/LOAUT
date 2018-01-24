package com.acme.DemoBoot.rest;
/*
 * controladora clasica
 * Para manejar cuando llamen a la raiz del proyecto
 * cuando llaman localhost/port -> para que llame a esta opcion se llama a una vista
 * 
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

	 @RequestMapping("/")
	 public String 	getIndexPage() {
		 return "UserManagment";
	 }
}
