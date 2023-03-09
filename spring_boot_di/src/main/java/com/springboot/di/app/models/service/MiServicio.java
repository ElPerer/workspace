package com.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Para inyectar un componente es necesario que esté dentro del package base, donde está la clase principal
//@Component("miServicioSimple")

//Con la anotación @Primary indicamos a Spring que servicio o clase se va a ejecutar primero o por defecto al iniciar la apliación
//@Primary
public class MiServicio implements InterfaceService{
	
	//La notación @Override que indica que el método de abajo es la implementación de un padre, en este caso de la clase Interface
	@Override
	public String operacion() {
		return "Ejecutando algún proceso simple";
	}
}
