package com.dim.agesilapi.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class LimpiezaChoque extends Incidencia{
	
	private String tipoChoque;
	private String gravedad;
	
	@Override
	public Categoria getCategoria() {
		return Categoria.LimpiezaChoque;
	}
    @Override
	public Categoria setCategoria() {		
		return Categoria.LimpiezaChoque;
	}
	public String getTipoChoque() {
		return tipoChoque;
	}
	public void setTipoChoque(String tipoChoque) {
		this.tipoChoque = tipoChoque;
	}
	public String getGravedad() {
		return gravedad;
	}
	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}   
    

}
