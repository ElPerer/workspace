package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		/*Con forward no se reinician los valores o parámetros es decir, no se pierden, con forward la ruta del navegador 
		 * no cambia a diferencia del redirect, el forward solamente se usa para las rutas de los controladores dentro del proyecto*/
		return "forward:/app/";
		
		//Con redirect se pierden todos los datos o la información, como son los parámetros y variables
		//return "redirect:/app/";
		
		//Envia a una URL externa
		// return "redirect:https://www.google.com";
	}
}
