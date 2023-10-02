package com.dim.agesilapi.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name="RECEPTOR")
public class Receptor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String zona;
	private String correo;
	private Long telefono;
	
//	@OneToMany(mappedBy = "repector")
//	List<Incidencia> incidencias;

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

//	public List<Incidencia> getIncidencias() {
//		return incidencias;
//	}
//
//	public void setIncidencias(List<Incidencia> incidencias) {
//		this.incidencias = incidencias;
//	}

//	@Override
//	public String toString() {
//		return "Receptor [id=" + id + ", zona=" + zona + ", correo=" + correo + ", telefono=" + telefono
//				+ ", incidencias=" + incidencias + "]";
//	}

	

}
