package com.noFrontier.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noFrontier.Entity.Usuario;;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario getByname(String name);
	

}