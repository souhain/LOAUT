package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//bean
@Controller
@RequestMapping("/say")

public class HelloWorldController {
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "helloWorld";
	}

}
