package com.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.web.app.models.Usuario;

@Controller
/*Al momento de poner RequestMapping antes de la declaración de la clase quiere decir que es la ruta inicial si se desea ingresar a las rutas
 * declaradas antes de los métodos de la misma clase */
@RequestMapping("/app")
public class IndexController {
	
	//Los valores dentro de la anotación @Value se encuentran en el archivo applicartion.properties, no acepta acentos o letras "ñ"
	//Esto se le conoce como inyecciones de dependencias
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping({"/index", "/", "/home", ""})
	/* public String index (Model model) {
		//Distintas formas de pasarle atributos a una vista HTML
		//Map<String, Object> -> map.put(clave, valor)
		//ModelAndView -> mv.addObject(clave, valor)
		//ModelMap -> model.addAttribute(clave, valor)
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	} */
	
	public ModelAndView index (ModelAndView modelView) {
		modelView.addObject("titulo", textoIndex);
		modelView.setViewName("index");
		return modelView;
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String perfil (Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Pedro");
		usuario.setApellido("Morales");
		//usuario.setEmail("pedromorales_96@hotmail.com");
		//Se pude concatenar con la función .concat(usuario.getNombre());
		model.addAttribute("titulo", textoPerfil + usuario.getNombre());
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar (ModelAndView modelView) {
		// Una forma de hacerlo es la siguiente
		// List<Usuario> usuarios = Arrays.asList(new Usuario("Pedro", "Morales", "correo@correo.com"),new Usuario("Pkos", "pekereke", "correo@didisee.com"),new Usuario("hermosa", "pke", "correopke@.com"));
		// List<Usuario> usuarios = new ArrayList<Usuario>();
		modelView.addObject("titulo", textoListar);
		
		/* usuarios.add(new Usuario("Pedro", "Morales", "correo@correo.com"));
		usuarios.add(new Usuario("Pkos", "pekereke", "correo@didisee.com"));
		usuarios.add(new Usuario("hermosa", "pke", "correopke@.com"));
		usuarios.add(new Usuario("Keñita", "Romero", "keñita@keñitona.com")); */
		// modelView.addObject("usuarios", usuarios);
		modelView.setViewName("listar");
		return modelView;
	}

	// Con ModelAttribute se pasan los parámetros a todos los métodos del controlador presente
	// La clave sería en al anotación, y el valor es lo que retorna el método a continuación
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Pedro", "Morales", "pedromorales"), new Usuario("Pkos", "Morales", "pedromorales"), new Usuario("Lalo", "Morales", "pedromorales"));
		return usuarios;
	}
	
	
}
