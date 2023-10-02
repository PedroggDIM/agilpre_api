package com.dim.agesilapi.REST;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dim.agesilapi.AgesilapiApplication;
import com.dim.agesilapi.entidades.CambiosDependencia;
import com.dim.agesilapi.entidades.DeficienciaServicio;
import com.dim.agesilapi.entidades.Receptor;
import com.dim.agesilapi.entidades.Usuario;
import com.dim.agesilapi.entidades.LimpiezaChoque;
import com.dim.agesilapi.repositorios.ReceptorRepositorio;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/receptores")
public class ReceptorController {
	private final ReceptorRepositorio repositorio;
	private ReceptorAssembler assembler;	
	//private final Logger log;

	ReceptorController(ReceptorRepositorio repositorio,
			ReceptorAssembler assembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		//this.log = AgesilapiApplication.log;

	}

	@GetMapping("{id}")
	public ReceptorModel one(@PathVariable Long id) {
		Receptor Receptor = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "Receptor"));
		//log.info("Recuperada la Receptor: " + Receptor);
		return assembler.toModel(Receptor);
	}

	@GetMapping
	public CollectionModel<ReceptorModel> all() {
		return assembler.toCollectionModel(repositorio.findAll());
	}


//	
//	@GetMapping("{id}/usuarios")
//	public CollectionModel<UsuarioModel> usuarios(@PathVariable Long id) {
//		Receptor Receptor = repositorio.findById(id)
//				.orElseThrow(() -> new RegisterNotFoundException(id, "Receptor"));
//		
		//return assembler.toCollectionModel(repositorio.findAll());
		
		//return equipoListaAssembler.toCollection(Receptor.getEquiposDeReceptor());
	//}
}

	


