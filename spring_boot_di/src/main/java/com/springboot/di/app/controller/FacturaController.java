package com.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.di.app.models.domain.Factura;

@Controller

@RequestMapping(value = "/factura", method = RequestMethod.GET)
public class FacturaController {
	
	//Inyectamos la factura
	@Autowired
	private Factura factura;
	
	@Value("${texto.facturacontroller.ver.titulo}")
	private String tituloVer;
	
	@RequestMapping(value = "/ver", method = RequestMethod.GET)
	public ModelAndView ver(ModelAndView modelView) {
		modelView.addObject("titulo", tituloVer);
		modelView.addObject("factura", factura);
		modelView.setViewName("factura/ver");
		return modelView;
	}

}
