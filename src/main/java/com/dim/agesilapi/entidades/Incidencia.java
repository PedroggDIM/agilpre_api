package com.dim.agesilapi.entidades;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="INCIDENCIAS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="categoria", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("null")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Incidencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private Date fechaInicio;
	private Date fechaFin;
	private int numDias;
	private String estado;
	private Date comunicaEmpresa;
	private String infoAdicio_grabador;
	private String descripcion;
	public static enum Categoria {
		DeficienciaServicio,
		LimpiezaChoque,
		CambiosDependencia
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UsuarioId")
	Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ReceptorId")
	Receptor receptor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UnidadId")
	Unidad unidad;
	
	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	public Categoria getCategoria() {
		return null;
	}
	public Categoria setCategoria() {		
		return null;
	}
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Receptor getReceptor() {
		return receptor;
	}
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", numDias="
				+ numDias + ", estado=" + estado + ", comunicaEmpresa=" + comunicaEmpresa + ", infoAdicio_grabador="
				+ infoAdicio_grabador + ", descripcion=" + descripcion + ", usuario=" + usuario + ", receptor="
				+ receptor + "]";
	}

	
	
}
