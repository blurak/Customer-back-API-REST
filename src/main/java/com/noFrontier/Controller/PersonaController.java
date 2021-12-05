package com.noFrontier.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noFrontier.Entity.Persona;
import com.noFrontier.Service.IPersonaService;


@Controller
@RestController
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	IPersonaService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/consultarTodas")
	public ResponseEntity<List<Persona>> consultarTodasPersonas(){
		return new ResponseEntity<List<Persona>>(service.listarTodasPersonas(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/crear")
	public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
		Persona p = service.crear(persona);
		if(p!= null) {
			return new ResponseEntity<Persona>(p, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		}
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/editar")	
	public ResponseEntity<Persona> editarPst( @RequestBody Persona persona){
		Persona p =service.editar(persona);
		return new ResponseEntity<Persona>(p,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarPersona(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>( HttpStatus.NO_CONTENT);
	}
	
	
}
