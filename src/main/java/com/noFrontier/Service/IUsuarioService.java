package com.noFrontier.Service;

import java.util.List;

import com.noFrontier.Entity.Usuario;


public interface IUsuarioService {
	
	public Usuario crear(Usuario persona);
	
	public void eliminar(Integer id);
	
	public List<Usuario> listarTodasPersonas();
	
	public Usuario editar(Usuario entidad);
	
	public Usuario iniciarSesion(String userName, String clave);
	
}
