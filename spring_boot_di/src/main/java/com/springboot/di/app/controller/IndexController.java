package com.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.di.app.models.service.InterfaceService;
import com.springboot.di.app.models.service.InterfaceServices;

@Controller
@RequestMapping(value = "/app", method = RequestMethod.GET)
public class IndexController {

	//La anotación Autowired se usa para inyectar un objeto que está declarado en el contenedor de Spring
	/*@Autowired
	private MiServicio servicio;
	
	@Autowired
	private Servicios servicios;]*/
	
	@Autowired
	//Con la anotación @Qualifier se coloca el nombre del componente que se quiere inyectar, siempre y cuando se use una Interface de java
	//El @Qualifier se usa cuando más de una clase implementa la misma Interface de java
	@Qualifier("miServicioSimple")
	private InterfaceService servicio;
	
	//Inyección por método constructor, cuando son inyecciones de este tipo no es necesario la anotación @Autowired
	//@Autowired
	/*public IndexController(InterfaceService servicio) {
		this.servicio = servicio;
	}*/
	
	//Como inyectar via método set por atributo y por el constructor
	//@Autowired
	/*public void setServicio(InterfaceService servicio) {
		
		//this.servicio es el atributo que se encuentra arriba
		this.servicio = servicio;
	}*/
	
	@Autowired
	private InterfaceServices servicios;
	
	//La anotación @Value es para inyectar una propiedad desde un archivo de properties
	@Value("${texto.indexcontroller.properties.titulo}")
	private String tituloPropertie;
	
	@RequestMapping(value = { "", "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView index( ModelAndView modelView) {
		
		modelView.addObject("titulo", "titulo para el index");
		modelView.addObject("objeto", servicio.operacion());
		modelView.addObject("servicio1", servicios.servicio1());
		modelView.addObject("servicio2", servicios.servicio2());
		modelView.setViewName("index");

		return modelView;
	}
	
	@RequestMapping(value = "/properties", method = RequestMethod.GET)
	public String properties( ModelMap modelMap ) {
		modelMap.addAttribute("titulo", tituloPropertie);
		return "index";
	}
}
