package com.noFrontier.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noFrontier.Entity.Usuario;
import com.noFrontier.Repository.IUsuarioRepository;
import com.noFrontier.Service.IUsuarioService;


@Service
public class UsuarioServiceImplementation implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository repository;

	public UsuarioServiceImplementation() {
		
	}
	@Override
	public Usuario editar(Usuario entidad) {
		Usuario us = repository.findById(entidad.getId()).get();
		if(us != null) {
			repository.save(entidad);
			return entidad;
		}
		return entidad;
	}

	

	@Override
	public Usuario crear(Usuario persona) {	
		Usuario per = repository.getByname(persona.getName());
		
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
	public List<Usuario> listarTodasPersonas() {
		List<Usuario> lista = new ArrayList<Usuario>();
		lista = repository.findAll();
		return lista;
	}
	@Override
	public Usuario iniciarSesion(String userName, String clave) {

		Usuario persona;
		
		persona = repository.getByname(userName);
		
		if(persona == null) {
			return null;
		}
		if(persona.getPassword().equals(clave)) {
			return persona;
		}
		
		return null;
	}
	

	
}
