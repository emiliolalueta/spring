package com.aarestu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//**Probar con las URL despues de hacer Maven--> install*****
//	http://localhost:8080/HelloMavenSpringWebMVC/hello/index
//	http://localhost:8080/HelloMavenSpringWebMVC/
@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Hola Spring WEB MVC!");
		return "hello";
	}

}
