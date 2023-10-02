package com.dim.agesilapi.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.dim.agesilapi.entidades.Unidad;

@Component
public class UnidadAssembler implements RepresentationModelAssembler<Unidad, UnidadModel>{

	@Override
	public UnidadModel toModel(Unidad entity) {
		UnidadModel model = new UnidadModel();
		
		model.setId(entity.getId());
		model.setZona(entity.getZona());
		model.setNombre(entity.getNombre());
		
		model.add(linkTo(methodOn(UnidadController.class).one(entity.getId())).withSelfRel());
	//	model.add(linkTo(methodOn(UnidadController.class).usuarios(entity.getId())).withRel("usuarios"));
		return model;
	}
	

}

