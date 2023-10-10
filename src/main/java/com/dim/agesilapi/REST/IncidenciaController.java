package com.dim.agesilapi.REST;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dim.agesilapi.dto.DataSession;
import com.dim.agesilapi.entidades.CambiosDependencia;
import com.dim.agesilapi.entidades.DeficienciaServicio;
import com.dim.agesilapi.entidades.Incidencia;
import com.dim.agesilapi.entidades.Incidencia.Categoria;
import com.dim.agesilapi.entidades.LimpiezaChoque;
import com.dim.agesilapi.entidades.Unidad;
import com.dim.agesilapi.repositorios.IncidenciaRepositorio;
import com.dim.agesilapi.repositorios.UnidadRepositorio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {
	private final IncidenciaRepositorio incRepositorio;
	private final IncidenciaRepositorio repositorio;
	private final UnidadRepositorio unidadRepositorio;
	
	private IncidenciaAssembler assembler = new IncidenciaAssembler();	
	//private final Logger log;

	IncidenciaController(IncidenciaRepositorio incRepositorio, IncidenciaRepositorio repositorio,
			UnidadRepositorio unidadRepositorio, IncidenciaAssembler assembler) {
		this.incRepositorio = incRepositorio;
		this.repositorio = repositorio;
		this.unidadRepositorio = unidadRepositorio;
		this.assembler = assembler;
		//this.log = AgesilapiApplication.log;

	}

	@GetMapping("{id}")
	public IncidenciaModel one(@PathVariable Long id) {
		Incidencia incidencia = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "incidencia"));
	//	log.info("Recuperada la incidencia: " + incidencia);
		return assembler.toModel(incidencia);
	}

	@PostMapping("all")
	public CollectionModel<IncidenciaModel> all(@RequestBody DataSession dataSession) {
		CollectionModel<IncidenciaModel> col;
		if(dataSession.getPerfil().equals("Administrador")) {
			col = assembler.toCollectionModel(repositorio.findAll());
		}else {
			Unidad unidad = unidadRepositorio.findByNombre(dataSession.getUnidad());
			col = assembler.toCollectionModel(repositorio.findByUnidad(unidad));
		}
		
		return col; 
	}

	@PostMapping
	public IncidenciaModel add(@RequestBody IncidenciaPostModel model) {
		Incidencia incidencia = repositorio.save(assembler.toEntity(model));
		//log.info("Añadido " + incidencia);
		return assembler.toModel(incidencia);
	}

	@PutMapping("{id}")
	public IncidenciaModel edit(@PathVariable Long id, @RequestBody IncidenciaModel model) {
	    Incidencia incidencia = repositorio.findById(id).map(pre -> {
	        
	        pre.setFechaInicio(model.getFechaInicio());
	        pre.setFechaFin(model.getFechaFin());
	        pre.setNumDias(model.getNumDias());
	        pre.setEstado(model.getEstado());
	        pre.setComunicaEmpresa(model.getComunicaEmpresa());
	        pre.setInfoAdicio_grabador(model.getInfoAdicio_grabador());
	        pre.setDescripcion(model.getDescripcion());	        
	        if (pre.getCategoria() == Categoria.DeficienciaServicio) {
	        	DeficienciaServicio defi = (DeficienciaServicio) pre;
	        	defi.setIncumplimiento(model.getIncumplimiento());
			} else if (pre.getCategoria() == Categoria.LimpiezaChoque) {
                LimpiezaChoque limpi = (LimpiezaChoque) pre;
                limpi.setTipoChoque(model.getTipoChoque());
                limpi.setGravedad(model.getGravedad());
			} else if (pre.getCategoria() == Categoria.CambiosDependencia) {
				CambiosDependencia cambios = (CambiosDependencia) pre;
				cambios.setTipoCambio(model.getTipoCambio());
				cambios.setTipoDependencia(model.getTipoDependencia());
				cambios.setMetrosCuadrados(model.getMetrosCuadrados());
			}
			return repositorio.save(pre);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "incidencia"));
	//	log.info("Actualizado " + incidencia);
		return assembler.toModel(incidencia);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		//log.info("Borrada incidencia " + id);
		repositorio.deleteById(id);

	}

}

	


