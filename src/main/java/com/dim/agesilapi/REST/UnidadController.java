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
import com.dim.agesilapi.entidades.Unidad;
import com.dim.agesilapi.entidades.Usuario;
import com.dim.agesilapi.entidades.LimpiezaChoque;
import com.dim.agesilapi.repositorios.UnidadRepositorio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/unidades")
public class UnidadController {
	private final UnidadRepositorio repositorio;
	private UnidadAssembler assembler;	
	//private final Logger log;

	UnidadController(UnidadRepositorio repositorio,
			UnidadAssembler assembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		//this.log = AgesilapiApplication.log;

	}

	@GetMapping("{id}")
	public UnidadModel one(@PathVariable Long id) {
		Unidad Unidad = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "Unidad"));
		//log.info("Recuperada la Unidad: " + Unidad);
		return assembler.toModel(Unidad);
	}

	@GetMapping
	public CollectionModel<UnidadModel> all() {
		return assembler.toCollectionModel(repositorio.findAll());
	}


//	
//	@GetMapping("{id}/usuarios")
//	public CollectionModel<UsuarioModel> usuarios(@PathVariable Long id) {
//		Unidad unidad = repositorio.findById(id)
//				.orElseThrow(() -> new RegisterNotFoundException(id, "unidad"));
//		
		//return assembler.toCollectionModel(repositorio.findAll());
		
		//return equipoListaAssembler.toCollection(unidad.getEquiposDeUnidad());
	//}
}

	


