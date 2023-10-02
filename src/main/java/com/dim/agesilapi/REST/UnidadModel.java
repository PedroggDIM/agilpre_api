package com.dim.agesilapi.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.dim.agesilapi.entidades.Usuario.UsuarioRol;

@Relation(itemRelation="usuario")
public class UnidadModel extends RepresentationModel<UnidadModel>{

	private Long id;
	private String zona;
	private String nombre;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
