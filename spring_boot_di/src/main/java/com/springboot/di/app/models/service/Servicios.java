package com.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

// @Component
public class Servicios implements InterfaceServices{
	
	@Override
	public String servicio1() {
		return "Este es el servicio 1";
	}
	
	@Override
	public String servicio2() {
		return "Este es el servicio 2";
	}
}
