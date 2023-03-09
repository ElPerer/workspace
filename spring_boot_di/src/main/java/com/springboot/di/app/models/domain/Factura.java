package com.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;



@Component

//Con la anotación @RequestScope dejan de ser singleton, es decir, si un componente no cuenta con esta misa anotación concatenará el valor
//que se crea al momento de refrescar el navegador, es decir, tienen que estar dentro del mismo request
@RequestScope
//@SessionScope

//Al usar la siguiente anotación es lo mismo que el singleton
@ApplicationScope
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 9047134564843636388L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	public Factura() {
		this.descripcion = "";
		this.cliente = new Cliente();
		this.items = null;
	}
	
	//La anotacion @PostContruct se ejecuta justo después de crear el objeto y después de inyectar las dependencias
	@PostConstruct
	public void inicializar() {
		cliente.setApellido(cliente.getApellido().concat(" ").concat("Jaramillo"));
		this.descripcion = this.descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	//Esto es antes que el objeto se destruya
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: " .concat(descripcion));
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	public List<ItemFactura> getItems() {
		return this.items;
	}
}
