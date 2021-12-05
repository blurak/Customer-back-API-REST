package com.noFrontier.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noFrontier.Entity.Persona;
import com.noFrontier.Repository.IPersonaRepository;
import com.noFrontier.Service.IPersonaService;


@Service
public class PersonaServiceImplementation implements IPersonaService{
	
	@Autowired
	IPersonaRepository repository;

	public PersonaServiceImplementation() {
		
	}
	@Override
	public Persona editar(Persona entidad) {
		Persona us = repository.findById(entidad.getId()).get();
		if(us != null) {
			repository.save(entidad);
			return entidad;
		}
		return entidad;
	}

	

	@Override
	public Persona crear(Persona persona) {	
		Persona per = repository.getByname(persona.getName());
		
		if(per == null) {
			repository.save(persona);
			return persona;
		}
		else {
			return null;
		}		
	}

	@Override
	public void eliminar(Integer id) {

		repository.deleteById(id);
		
	}

	@Override
	public List<Persona> listarTodasPersonas() {
		List<Persona> lista = new ArrayList<Persona>();
		lista = repository.findAll();
		return lista;
	}

	
}
