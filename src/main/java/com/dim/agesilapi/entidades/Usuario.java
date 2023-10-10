package com.dim.agesilapi.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	public static final String CORREO = "correo";
	public static final String CONTRASENIA = "contrasenia";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String correo;
	private String contrasenia;
	private String tip;
	public static enum UsuarioRol {
		Grabador,
		Administrador
	}
	private UsuarioRol usuarioRol = UsuarioRol.Grabador;
	
//	@OneToMany(mappedBy = "usuario")
//	List<Incidencia> incidencias;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UnidadId")
	Unidad unidad;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public UsuarioRol getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(UsuarioRol estado) {
		this.usuarioRol = usuarioRol;
	}

//	public List<Incidencia> getIncidencias() {
//		return incidencias;
//	}
//
//	public void setIncidencias(List<Incidencia> incidencias) {
//		this.incidencias = incidencias;
//	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

//	@Override
//	public String toString() {
//		return "Usuario [id=" + id + ", id_unidad=" + id_unidad + ", correo=" + correo + ", contrasenia=" + contrasenia
//				+ ", tip=" + tip + ", estado=" + estado + ", incidencias=" + incidencias + ", unidad=" + unidad + "]";
//	}

	

}
