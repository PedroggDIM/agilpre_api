package com.dim.agesilapi.REST;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.dim.agesilapi.entidades.Incidencia.Categoria;

@Relation(itemRelation="incidencia")
public class IncidenciaModel extends RepresentationModel<IncidenciaModel>{

	private Long id;	
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
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getNumDias() {
		return numDias;
	}
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getComunicaEmpresa() {
		return comunicaEmpresa;
	}
	public void setComunicaEmpresa(Date comunicaEmpresa) {
		this.comunicaEmpresa = comunicaEmpresa;
	}
	public String getInfoAdicio_grabador() {
		return infoAdicio_grabador;
	}
	public void setInfoAdicio_grabador(String infoAdicio_grabador) {
		this.infoAdicio_grabador = infoAdicio_grabador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public ArrayList<String> getIncumplimiento() {
		return incumplimiento;
	}
	public void setIncumplimiento(ArrayList<String> incumplimiento) {
		this.incumplimiento = incumplimiento;
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
