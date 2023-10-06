package com.dim.agesilapi.REST;

import java.util.Optional;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dim.agesilapi.entidades.Usuario;
import com.dim.agesilapi.entidades.Usuario.UsuarioRol;
import com.dim.agesilapi.repositorios.UsuarioRepositorio;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;
	
	LoginController(UsuarioRepositorio repositorio, UsuarioAssembler assembler
			) {
		this.repositorio = repositorio;
		this.assembler = assembler;
	}


	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginModel model) {
	    Usuario usuario = repositorio.findByCorreoAndContrasenia(model.getCorreo(), model.getContrasenia());
		
	    
	    if (usuario != null) {
	        UsuarioRol perfil = usuario.getUsuarioRol();
	        String zona = usuario.getUnidad().getZona();
	        String unidad = usuario.getUnidad().getNombre();
	        
	        JSONObject responseJson = new JSONObject();
	        responseJson.put("perfil", perfil);
	        responseJson.put("zona", zona);
	        responseJson.put("unidad", unidad);
	        
	        return ResponseEntity.ok(responseJson.toString());
	    } else {
	    	System.out.println("el usuario no existe");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
	    }
	}

}