package com.dim.agesilapi.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.dim.agesilapi.entidades.CambiosDependencia;
import com.dim.agesilapi.entidades.DeficienciaServicio;
import com.dim.agesilapi.entidades.Incidencia;
import com.dim.agesilapi.entidades.Incidencia.Categoria;
import com.dim.agesilapi.entidades.LimpiezaChoque;
import com.dim.agesilapi.entidades.Usuario;

@Component
public class IncidenciaAssembler implements RepresentationModelAssembler<Incidencia, IncidenciaModel>{

	@Override
	public IncidenciaModel toModel(Incidencia entity) {
		IncidenciaModel model = new IncidenciaModel();
		
		model.setId(entity.getId());
		model.setFechaInicio(entity.getFechaInicio());
		model.setFechaFin(entity.getFechaFin());
		model.setNumDias(entity.getNumDias());
		model.setEstado(entity.getEstado());
		model.setComunicaEmpresa(entity.getComunicaEmpresa());
		model.setInfoAdicio_grabador(entity.getInfoAdicio_grabador());
		model.setDescripcion(entity.getDescripcion());
		if(entity.getCategoria() == Categoria.DeficienciaServicio) {
		    model.setCategoria(Categoria.DeficienciaServicio);
			model.setIncumplimiento(((DeficienciaServicio) entity).getIncumplimiento());
		}else if(entity.getCategoria() == Categoria.LimpiezaChoque) {
		    model.setCategoria(Categoria.LimpiezaChoque);
		    model.setGravedad(((LimpiezaChoque) entity).getGravedad());
			model.setTipoChoque(((LimpiezaChoque) entity).getTipoChoque());;
		}else if(entity.getCategoria() == Categoria.CambiosDependencia) {
		    model.setCategoria(Categoria.CambiosDependencia);
		    model.setTipoCambio(((CambiosDependencia) entity).getTipoCambio());			
			model.setTipoDependencia(((CambiosDependencia) entity).getTipoDependencia());
			model.setMetrosCuadrados(((CambiosDependencia) entity).getMetrosCuadrados()); 
		}
		
		model.add(linkTo(methodOn(IncidenciaController.class).one(entity.getId())).withSelfRel());
		//model.add(linkTo(methodOn(UsuarioController.class).one(entity.getUsuario().getId())).withRel("usuario"));
		return model;
	
	}
	public Incidencia toEntity(IncidenciaPostModel model) {

		Incidencia incidencia = new Incidencia();
		
		if (model.getCategoria() ==  Categoria.DeficienciaServicio) {
			DeficienciaServicio def = new DeficienciaServicio();
			def.setIncumplimiento(model.getIncumplimiento());
			incidencia = def;			
		}
		else if(model.getCategoria() == Categoria.LimpiezaChoque) {
			LimpiezaChoque limp = new LimpiezaChoque();
			limp.setTipoChoque(model.getTipoChoque());
			limp.setGravedad(model.getGravedad());
			incidencia = limp;
		}
		else if(model.getCategoria() == Categoria.CambiosDependencia) {
			CambiosDependencia cam = new CambiosDependencia();
			cam.setTipoCambio(model.getTipoCambio());
			cam.setTipoDependencia(model.getTipoDependencia());
			cam.setMetrosCuadrados(model.getMetrosCuadrados());
			incidencia = cam;
		}
		
		
		
		incidencia.setFechaInicio(model.getFechaInicio());
		incidencia.setFechaFin(model.getFechaFin());
		incidencia.setNumDias(model.getNumDias());
		incidencia.setEstado(model.getEstado());
		incidencia.setComunicaEmpresa(model.getComunicaEmpresa());
		incidencia.setInfoAdicio_grabador(model.getInfoAdicio_grabador());
		incidencia.setDescripcion(model.getDescripcion());
	
		return incidencia;
	}

}

