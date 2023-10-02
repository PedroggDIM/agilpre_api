package com.dim.agesilapi.entidades;
import java.util.*;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class DeficienciaServicio extends Incidencia{

	ArrayList<String> incumplimiento = new ArrayList<String>();
	
	@Override
	public Categoria getCategoria() {		
		return Categoria.DeficienciaServicio;
	}	
	@Override
	public Categoria setCategoria() {		
		return Categoria.DeficienciaServicio;
	}
	public ArrayList<String> getIncumplimiento() {
		return incumplimiento;
	}
	public void setIncumplimiento(ArrayList<String> incumplimiento) {
		this.incumplimiento = incumplimiento;
	}	

}
