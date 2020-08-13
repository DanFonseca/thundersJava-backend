package com.br.thundersJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.thundersJava.dao.GerenteDAO;
import com.br.thundersJava.model.Gerente;

@RestController
@CrossOrigin("*")
public class GerenteController {
	
	@Autowired
	private GerenteDAO gerenteDAO;

	@PostMapping("/login")
	public ResponseEntity<Gerente> login (@RequestBody Gerente gerente){
		Gerente obj = null;
		System.out.println("OBJETO GERENTE " + gerente);
	
		if(gerente.getNome().length() == 9) {
			obj = gerenteDAO.findByFuncionalAndSenha(gerente.getNome(), gerente.getSenha());
		}else {
			obj = gerenteDAO.findByRacfAndSenha(gerente.getNome(), gerente.getSenha());
		}
	
		return obj == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(gerente);
			
	}
	


}
