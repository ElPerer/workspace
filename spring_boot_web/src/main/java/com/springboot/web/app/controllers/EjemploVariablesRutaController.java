package com.springboot.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelView) {
		modelView.addObject("titulo", "Index de @PathVariable envíar parámetros");
		modelView.setViewName("variables/index");
		return modelView;
	}
	
	//Con @PathVariable no es necesario colocar el ?param=valor para poder envíar el parámetro, simplemente como viene en la ruta de abajo /param
	@RequestMapping(value = "/string/{texto}")
	public String varible(@PathVariable(name = "texto") String texto, Map<String, Object> map) {
		map.put("titulo", "Ejemplo de parámetros con @PathVariable");
		map.put("resultado", "El valor del parámetro es: " .concat(texto));
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable(name = "texto") String texto, @PathVariable(name = "numero") int numero, ModelMap modelMap) {
		modelMap.addAttribute("titulo", "Ejemplo con dos variables con @PathVariable");
		modelMap.addAttribute("resultado", " El primer parámetro es: " .concat(texto) + " y el segundo es: " + numero);
		return "variables/ver";
	}
}
