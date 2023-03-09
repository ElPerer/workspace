package com.springboot.di.app.models.domain;

public class Producto {
	
	private String nombre;
	private float precio;
	
	public Producto() {
		this.nombre = "";
		this.precio = 0;
	}
	
	public Producto(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPrecio() {
		return this.precio;
	}
}
