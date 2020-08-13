package com.br.thundersJava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.thundersJava.dao.AgenciaDAO;
import com.br.thundersJava.model.Agencia;

@RestController
@CrossOrigin("*")
public class AgenciaController {

	@Autowired
	private AgenciaDAO agenciaDAO;
	

	@GetMapping("/agencias")
	public ResponseEntity<List<Agencia>> retornarAgencias(){
		ArrayList<Agencia> lista = (ArrayList<Agencia>) agenciaDAO.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("agencia/{id}")
	public ResponseEntity<Agencia> pesquisarPorCodigo(@PathVariable int id){
		Agencia objeto = agenciaDAO.findById(id).orElse(null);
		if (objeto==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(objeto);
	}
	
	
}
