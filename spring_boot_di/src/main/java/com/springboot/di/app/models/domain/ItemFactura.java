package com.springboot.di.app.models.domain;

public class ItemFactura {
	
	private Producto producto;
	private int cantidad;
	
	public ItemFactura() {
		this.producto = new Producto();
		this.cantidad = 0;
	}
	
	public ItemFactura(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Producto getProducto() {
		return this.producto;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	
	public float total() {
		return this.cantidad * producto.getPrecio();
	}
}
