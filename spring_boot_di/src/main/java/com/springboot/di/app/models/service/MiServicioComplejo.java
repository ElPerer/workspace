package com.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

//Se le pueden poner nombres a los componentes creados en Spring, como se ve a continuación
//@Component("miServicioComplejo")
public class MiServicioComplejo implements InterfaceService{
	
	public String operacion() {
		return "Esto es una operación obtenida con la notación @Primary";
	}

}
