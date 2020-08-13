package com.br.thundersJava.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.thundersJava.dao.AgenciaDAO;
import com.br.thundersJava.dao.AgendamentoDAO;
import com.br.thundersJava.model.Agencia;
import com.br.thundersJava.model.Agendamento;

@RestController
@CrossOrigin("*")
public class RelatorioController {
	
	@Autowired
	private AgenciaDAO agenciaDAO;
	
	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@GetMapping("/agendamentoNomeAgencia/{nomeAgencia}")
	public ResponseEntity<List<Agencia>> agendamentoPorAgencia (@PathVariable String nomeAgencia){
		List<Agencia> agencias = agenciaDAO.findBynomeAgencia(nomeAgencia);
		
		return agencias.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(agencias);
	}
	
	
	@GetMapping("/agendamentoData/{data}")
	public ResponseEntity<List<Agendamento>> agendamentoPorData (
			@PathVariable (value="data") 
			@DateTimeFormat(pattern="dd-MM-yyyy") Date data) 
			throws ParseException{

		 
		List<Agendamento> agendamentos = agendamentoDAO.findByData(data);
		
		return agendamentos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(agendamentos);
	}
	
	
//	@GetMapping("/agendamentoNomeCliente/{nome}")
//	public ResponseEntity<List<Agendamento>> relatorioPorNomeCliente (
//			@PathVariable  String nomeCliente) 
//			throws ParseException{
//
//		 
//		List<Agendamento> agendamentos = agendamentoDAO.findByData(data);
//		
//		return agendamentos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(agendamentos);
//	}
}
