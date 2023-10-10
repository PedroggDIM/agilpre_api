package com.dim.agesilapi.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dim.agesilapi.entidades.Unidad;

public interface UnidadRepositorio  extends JpaRepository<Unidad, Long>{

	Unidad findByNombre(String nombre);
	
	Unidad findByNombreAndZona(String nombre, String zona);
}
