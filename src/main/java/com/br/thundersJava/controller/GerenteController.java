package com.br.thundersJava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	//retorna mais de um gerente
		@GetMapping("/gerentes")
		public ResponseEntity<List<Gerente>> retornarGerentes(){
			ArrayList<Gerente> lista = (ArrayList<Gerente>) gerenteDAO.findAll();
			if (lista.size()==0) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(lista);
		}
		
		@GetMapping("/gerente/{id}")
		public ResponseEntity<Gerente> pesquisarId(@PathVariable int id){
			Gerente objeto = gerenteDAO.findById(id).orElse(null);
			if (objeto==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(objeto);
		}

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
	
	@PostMapping("/login/email")
	public ResponseEntity<Gerente> loginByEmail(@RequestBody Gerente gerente){
		Gerente obj = gerenteDAO.findByEmailAndSenha(gerente.getEmail(), gerente.getSenha());
		if (obj==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(obj);
	}
	


}//fecha classe
