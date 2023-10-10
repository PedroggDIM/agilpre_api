package com.dim.agesilapi.repositorios.specs;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.dim.agesilapi.entidades.Usuario;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class IncidenciaSpecs {

	public static Specification<Usuario> findByCorreoYPass(String correo, String pass) {
		return new Specification<Usuario>() {
			private static final long serialVersionUID = 6194698709625465812L;

			@Override
			public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				Predicate predicate =
						criteriaBuilder.and(criteriaBuilder.equal(root.get(Usuario.CORREO), correo),
						criteriaBuilder.equal(root.get(Usuario.CONTRASENIA), pass));

				return predicate;
			}
		};
	}

}