package com.dim.agesilapi.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dim.agesilapi.entidades.Incidencia;
import com.dim.agesilapi.entidades.Unidad;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Long> {

	List<Incidencia> findByUnidad(Unidad unidad);
}
