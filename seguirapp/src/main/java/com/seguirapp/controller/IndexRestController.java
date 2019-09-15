package com.seguirapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET) //Dir, root
	public String index() {
		return "Hello"; //nmTemplate
	}
}
