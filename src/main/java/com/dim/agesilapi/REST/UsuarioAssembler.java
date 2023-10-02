package com.dim.agesilapi.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.dim.agesilapi.entidades.Usuario;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, UsuarioModel>{

	@Override
	public UsuarioModel toModel(Usuario entity) {
		UsuarioModel model = new UsuarioModel();
		
		model.setId(entity.getId());
		model.setCorreo(entity.getCorreo());
		model.setTip(entity.getTip());
		model.setUsuarioRol(entity.getUsuarioRol());
		
		
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel(),
		   			linkTo(methodOn(UnidadController.class).one(entity.getUnidad().getId())).withRel("unidad")
				);
		return model;
	}
}


