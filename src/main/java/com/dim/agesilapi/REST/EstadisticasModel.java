package com.dim.agesilapi.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.dim.agesilapi.entidades.Usuario.UsuarioRol;

@Relation(itemRelation="incidencia")
public class EstadisticasModel extends RepresentationModel<EstadisticasModel>{

	private int numIncidencias;

	public int getNumIncidencias() {
		return numIncidencias;
	}

	public void setNumIncidencias(int numIncidencias) {
		this.numIncidencias = numIncidencias;
	}


}
