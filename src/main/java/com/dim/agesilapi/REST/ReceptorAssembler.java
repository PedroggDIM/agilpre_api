package com.dim.agesilapi.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.dim.agesilapi.entidades.Receptor;


@Component
public class ReceptorAssembler implements RepresentationModelAssembler<Receptor, ReceptorModel>{

	@Override
	public ReceptorModel toModel(Receptor entity) {
		ReceptorModel model = new ReceptorModel();
		
		model.setId(entity.getId());
		model.setZona(entity.getZona());
		model.setCorreo(entity.getCorreo());
		model.setTelefono(entity.getTelefono());
		
		model.add(linkTo(methodOn(ReceptorController.class).one(entity.getId())).withSelfRel());
		//model.add(linkTo(methodOn(ReceptorController.class).usuarios(entity.getId())).withRel("usuarios"));
		return model;
	}
	

}

