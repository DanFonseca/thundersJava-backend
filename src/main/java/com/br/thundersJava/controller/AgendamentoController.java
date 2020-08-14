package com.br.thundersJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.thundersJava.dao.AgendamentoDAO;
import com.br.thundersJava.model.Agencia;
import com.br.thundersJava.model.Agendamento;
import com.br.thundersJava.services.EmailServiceImpl;

@RestController
@CrossOrigin("*")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoDAO agendaDAO;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	
	@PostMapping("/agendar")
	public ResponseEntity<Agendamento> GravarAgenda(@RequestBody Agendamento agendaamento){
		
		Agendamento obj = agendaDAO.save(agendaamento);

		if(obj != null) {
			emailServiceImpl.sendSimpleMessage(obj);
			return ResponseEntity.ok(agendaamento);
		}

		return ResponseEntity.status(403).build(); 
	}

	@PostMapping("/agendarTodos")
	public ResponseEntity<List<Agendamento>> gravar (@RequestBody List<Agendamento> agendamentos){
		List<Agendamento> obj = (List<Agendamento>) agendaDAO.saveAll(agendamentos);
		return ResponseEntity.ok(obj);
	}
}
