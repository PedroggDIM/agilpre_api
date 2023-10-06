package com.dim.agesilapi.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dim.agesilapi.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	Usuario findByCorreoAndContrasenia(String correo, String contrasenia);


}
