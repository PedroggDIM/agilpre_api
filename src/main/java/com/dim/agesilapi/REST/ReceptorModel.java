package com.dim.agesilapi.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.dim.agesilapi.entidades.Usuario.UsuarioRol;

@Relation(itemRelation="usuario")
public class ReceptorModel extends RepresentationModel<ReceptorModel>{

	private Long id;
	private String zona;
	private String correo;
	private Long telefono;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	
}
