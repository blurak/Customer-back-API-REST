package com.noFrontier.Service;

import java.util.List;

import com.noFrontier.Entity.Persona;


public interface IPersonaService {
	
	public Persona crear(Persona persona);
	
	public void eliminar(Integer id);
	
	public List<Persona> listarTodasPersonas();
	
	public Persona editar(Persona entidad);
	
}
