package com.dim.agesilapi.REST;
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
import com.dim.agesilapi.entidades.Usuario;
import com.dim.agesilapi.entidades.LimpiezaChoque;
import com.dim.agesilapi.repositorios.UsuarioRepositorio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioRepositorio repositorio;
	private UsuarioAssembler assembler;	
	//private final Logger log;

	UsuarioController(UsuarioRepositorio repositorio,
			UsuarioAssembler assembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		//this.log = AgesilapiApplication.log;

	}

	@GetMapping("{id}")
	public UsuarioModel one(@PathVariable Long id) {
		Usuario Usuario = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "Usuario"));
		//log.info("Recuperada la Usuario: " + Usuario);
		return assembler.toModel(Usuario);
	}

	@GetMapping
	public CollectionModel<UsuarioModel> all() {
		return assembler.toCollectionModel(repositorio.findAll());
	}


}

	


