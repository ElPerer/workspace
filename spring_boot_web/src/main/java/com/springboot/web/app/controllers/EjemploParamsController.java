package com.springboot.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String param(@RequestParam(name="texto", defaultValue = "") String texto, Model model) {
		model.addAttribute("titulo", "Recibir parámetros del request HTTP GET");
		model.addAttribute("resultado", "El paramero enviado es: " .concat(texto));
		return "params/ver";
	}

	
	// Si se deja solamente la ruta o el path el método por defecto es GET
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index(Map<String, Object> map) {
		map.put("titulo", "Enviar parámetros del Request con MAP");
		return "params/index";
	}

	@GetMapping("/mix_params")
	public String params(@RequestParam(name = "texto", defaultValue = "") String texto, @RequestParam(name = "numero", defaultValue = "") int numero, ModelMap modelMap) {
		modelMap.addAttribute("titulo", "Parámetros mixtos con ModelMap");
		modelMap.addAttribute("resultado", "El texto contiene: " .concat(texto) + " El número es: " .concat(numero+""));
		return "params/ver";
	}
	
	//Ejemplo de como obtener parámetros con HttpServletRequest
	// El nombre de cada uno de los parámetros se definen en el método getParameter("nombreParam");
	@RequestMapping(value = "/mix_params_request", method = RequestMethod.GET)
	public String param(HttpServletRequest request, ModelMap modelMap) {
		String texto = request.getParameter("texto");
		int numero = 0;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		modelMap.addAttribute("titulo", "Ejemplo de como obtener con HttpServletRequest");
		modelMap.addAttribute("resultado", "El texto contiene: " .concat(texto) + " El número es: " .concat(numero+""));
		return "params/ver";
	}
}
