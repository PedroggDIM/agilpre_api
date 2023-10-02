package com.dim.agesilapi.entidades;

import com.dim.agesilapi.entidades.Incidencia.Categoria;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("C")
public class CambiosDependencia extends Incidencia{
	
	private String tipoCambio;
	private String tipoDependencia;
	private double metrosCuadrados;
	
	@Override
	public Categoria getCategoria() {
		return Categoria.CambiosDependencia;
	}
    @Override
	public Categoria setCategoria() {		
		return Categoria.CambiosDependencia;
	}
	public String getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public String getTipoDependencia() {
		return tipoDependencia;
	}
	public void setTipoDependencia(String tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
	}
	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}   

}
