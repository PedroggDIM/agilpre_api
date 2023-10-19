package com.dim.agesilapi.repositorios;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dim.agesilapi.entidades.Incidencia;
import com.dim.agesilapi.entidades.Unidad;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Long> {

	List<Incidencia> findByUnidad(Unidad unidad);

	@Query(value="SELECT count(*) FROM public.incidencias "
			+ "WHERE estado = :estado "
			+ "AND fecha_inicio >= :fechaInicio "
			+ "AND fecha_fin <= :fechaFin", nativeQuery = true) 
	int obtenerNumeroDeIncidencias(@Param("estado") String estado,
			@Param("fechaInicio") LocalDate fechaInicio,
			@Param("fechaFin") LocalDate fechaFin
			);
	
}
