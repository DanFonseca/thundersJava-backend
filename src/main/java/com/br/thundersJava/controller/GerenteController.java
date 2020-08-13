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

	@PostMapping("/login/racf")
	public ResponseEntity<Gerente> loginByRacf (@RequestBody Gerente gerente){
		
		 Gerente obj = gerenteDAO.findByRacfAndSenha(gerente.getRacf(), gerente.getSenha());
			
			return obj == null ? ResponseEntity.notFound().build() :
				ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/login/funcional")
	public ResponseEntity<Gerente> loginByFuncional (@RequestBody Gerente gerente){
	
		Gerente obj = gerenteDAO.findByFuncionalAndSenha(gerente.getFuncional(), gerente.getSenha());
			
		return obj == null ? ResponseEntity.notFound().build() :
			ResponseEntity.ok().body(obj);
	}
}
