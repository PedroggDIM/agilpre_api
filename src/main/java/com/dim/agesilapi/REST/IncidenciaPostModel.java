package com.dim.agesilapi.REST;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.dim.agesilapi.entidades.Incidencia.Categoria;
import com.dim.agesilapi.entidades.Receptor;
import com.dim.agesilapi.entidades.Usuario;

@Relation(itemRelation="incidencia")
public class IncidenciaPostModel extends RepresentationModel<IncidenciaPostModel>{

	private Date fechaInicio;
	private Date fechaFin;
	private int numDias;
	private String estado;
	private Date comunicaEmpresa;
	private String infoAdicio_grabador;
	private String descripcion;
	public Categoria categoria; 
	//Atributos Categoria DeficienciaServicio
	ArrayList<String> incumplimiento = new ArrayList<String>();
	//Atributos Categoria LimpiezaChoque
	private String tipoChoque;
	private String gravedad;
	//Atributos Categoria CambiosDependencia
	private String tipoCambio;
	private String tipoDependencia;
	private double metrosCuadrados;
	private Usuario usuario;
	private Receptor receptor;
	private String zona;
	private String unidad;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public int getNumDias() {
		return numDias;
	}
	public String getEstado() {
		return estado;
	}
	public Date getComunicaEmpresa() {
		return comunicaEmpresa;
	}
	public String getInfoAdicio_grabador() {
		return infoAdicio_grabador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public ArrayList<String> getIncumplimiento() {
		return incumplimiento;
	}
	public String getTipoChoque() {
		return tipoChoque;
	}
	public String getGravedad() {
		return gravedad;
	}
	public String getTipoCambio() {
		return tipoCambio;
	}
	public String getTipoDependencia() {
		return tipoDependencia;
	}
	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Receptor getReceptor() {
		return receptor;
	}
	
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
}
