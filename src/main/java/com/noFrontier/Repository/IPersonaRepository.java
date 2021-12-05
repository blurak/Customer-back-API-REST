package com.noFrontier.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noFrontier.Entity.Persona;;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
	
	public Persona getByname(String name);
	

}
