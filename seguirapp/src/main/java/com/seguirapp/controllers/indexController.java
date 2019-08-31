package com.seguirapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/") //Dir, root
	public String index() {
		return "index"; //nmTemplate
	}
}
