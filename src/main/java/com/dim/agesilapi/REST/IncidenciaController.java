package com.dim.agesilapi.REST;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import com.dim.agesilapi.dto.DataSession;
import com.dim.agesilapi.entidades.CambiosDependencia;
import com.dim.agesilapi.entidades.DeficienciaServicio;
import com.dim.agesilapi.entidades.Incidencia;
import com.dim.agesilapi.entidades.Incidencia.Categoria;
import com.dim.agesilapi.entidades.LimpiezaChoque;
import com.dim.agesilapi.entidades.Unidad;
import com.dim.agesilapi.repositorios.IncidenciaRepositorio;
import com.dim.agesilapi.repositorios.UnidadRepositorio;
import com.dim.agesilapi.REST.EstadisticasModel;

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
	public RedirectView delete(@PathVariable Long id) {
		//log.info("Borrada incidencia " + id);
	//	repositorio.deleteById(id);
		repositorio.deleteById(id);
	    
	    // Redirige a la misma página o a la página deseada después de borrar la incidencia
	    // En este ejemplo, redirige al inicio de la aplicación.
	    String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
	    return new RedirectView(baseUrl + "/");
	}	
	
	@GetMapping("/obtenerNumeroIncidencias")
	public EstadisticasModel obtenerNumeroIncidencias(@RequestParam("estado") String estado,
	     	@RequestParam("fechaInicio") LocalDate fechaInicio,
			@RequestParam("fechaFin") LocalDate fechaFin
			) {	
		int numIncidencias = repositorio.obtenerNumeroDeIncidencias(estado, fechaInicio, fechaFin);
		EstadisticasModel estadisticasModel = new EstadisticasModel();
		estadisticasModel.setNumIncidencias(numIncidencias);
		return estadisticasModel;
	}

}

	


