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

import com.noFrontier.Entity.Usuario;
import com.noFrontier.Service.IUsuarioService;


@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	IUsuarioService service;
	
	
	@GetMapping("/consultarTodas")
	public ResponseEntity<List<Usuario>> consultarTodasPersonas(){
		return new ResponseEntity<List<Usuario>>(service.listarTodasPersonas(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/crear")
	public ResponseEntity<Usuario> crearPersona(@RequestBody Usuario persona){
		Usuario p = service.crear(persona);
		if(p!= null) {
			return new ResponseEntity<Usuario>(p, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
		}
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/editar")	
	public ResponseEntity<Usuario> editarPst( @RequestBody Usuario persona){
		Usuario p =service.editar(persona);
		return new ResponseEntity<Usuario>(p,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarPersona(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>( HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/iniciarSesion/{userName}/{clave}")
	public ResponseEntity<Usuario> iniciarSesion(@PathVariable String userName, @PathVariable String clave){
		Usuario persona = service.iniciarSesion(userName, clave);
		if(persona == null) {
			return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Usuario>(persona, HttpStatus.OK);
	}
	
	
}
