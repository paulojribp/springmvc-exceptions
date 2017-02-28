package org.paulojr.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping()
	public String index() throws Exception {
		if (true) throw new Exception("ops.. agora já era");
		
		return "index";
	}
	
}
