package com.saifiahmada.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public String index(){
		return "index";
	}
	
	@ModelAttribute("page")
	public String page(){
		return "home";
	}

}
