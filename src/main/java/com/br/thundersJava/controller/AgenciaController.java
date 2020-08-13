package com.br.thundersJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/relatorio")
	public ResponseEntity<List<Agencia>> agendamentoPorAgencia (@RequestParam(name = "nomeAgencia") String nomeAgencia){
		List<Agencia> agencias = agenciaDAO.findBynomeAgencia(nomeAgencia);
		
		return agencias.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(agencias);
	}
	
}
