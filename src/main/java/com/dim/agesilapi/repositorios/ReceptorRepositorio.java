package com.dim.agesilapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dim.agesilapi.entidades.Incidencia;
import com.dim.agesilapi.entidades.Receptor;

public interface ReceptorRepositorio extends JpaRepository<Receptor, Long>{

}
