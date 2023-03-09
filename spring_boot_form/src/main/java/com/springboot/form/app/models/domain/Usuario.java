package com.springboot.form.app.models.domain;

import jakarta.validation.constraints.NotEmpty;

public class Usuario {
	
	//El @NotEmpty es para cuando los campos son requeridos, es decir, que no sean vacíos
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String email;
	
	public Usuario() {
		this.username = "";
		this.password = "";
		this.email = "";
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
