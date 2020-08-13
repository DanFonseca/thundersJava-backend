package com.br.thundersJava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.thundersJava.dao.AgenciaDAO;
import com.br.thundersJava.dao.AgendamentoDAO;
import com.br.thundersJava.dao.GerenteDAO;
import com.br.thundersJava.model.Agencia;
import com.br.thundersJava.model.Agendamento;
import com.br.thundersJava.model.Gerente;

@Configuration
public class configs implements CommandLineRunner  {
	
	@Autowired
	private GerenteDAO gerenteDAO;
	
	@Autowired
	private AgenciaDAO agenciaDAO;
	
	@Autowired
	private AgendamentoDAO agendamentoDAO;

	@Override
	public void run(String... args) throws Exception {	
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		gerenteDAO.deleteAll();
		agenciaDAO.deleteAll();
		agendamentoDAO.deleteAll();
		
        //criando os gerentes
		Gerente daniel = new Gerente(0,"daniel","987312845", "dafrefo", "123", "daniel.jpeg","daniel@daniel.com");
		Gerente adriana = new Gerente(0,"adriana","912365785", "asgasdc", "456", "adriana.jpeg", "adriana@adriana.com");
		
		//criando cadastro de agencias.
		Agencia mooca = new Agencia(0,"Itaú Mooca","09:00","14:00", null);
		Agencia interlagos = new Agencia(0,"Itaú Interlagos","09:00","14:00", null);
		Agencia jabaquara = new Agencia(0,"Itaú Jabaquara","09:00","14:00", null);
		Agencia morumbi = new Agencia(0,"Itaú Morumbi","09:00","14:00", null);
		
		agenciaDAO.saveAll(Arrays.asList(mooca, interlagos, jabaquara, morumbi));
	
		//Criando os Agendamentos
		Agendamento jorge = new Agendamento(0,"Jorge Rodrigues","jorge@ggmail.com", "(11)95873-0053",sdf.parse("2020-10-15"), "09:00", "Tirar Extrato Bancário", interlagos  );
		Agendamento paloma = new Agendamento(0,"Paloma Wadovski", "paloma.wadovski@gmail.com", "(11)94523-9874",sdf.parse("2020-10-18"), "11:00", "Trocar conta bancária", morumbi );
		Agendamento cecilia = new Agendamento(0, "Cecilia Meira", "Cecilia@ggmail.com", "(11)94893-5813",sdf.parse("2020-10-17"), "13:00", "Abrir Conta", mooca );
		Agendamento pedro = new Agendamento(0,"Pedro", "pedro_ribeiro@gmail.com", "(11)97841-3214", sdf.parse("2020-10-03"), "14:00", "Recuperar a senha do cartão de crédito", jabaquara  );
		Agendamento marcela = new Agendamento(0, "Marcela", "marcela.moreira@outlook.com", "(11)95213-6931",sdf.parse("2020-08-25"), "12:30", "Falar com meu Gerente", mooca );
		Agendamento douglas = new Agendamento(0,"Douglas Oliveira", "douglas.oliveira@outlook.com", "(11)98523-5476", sdf.parse("2020-09-02"), "13:25", "Investir em ações ITAÚSA", interlagos );
		
		
		agendamentoDAO.saveAll(Arrays.asList(jorge, cecilia, pedro, marcela,paloma, douglas));
		
		gerenteDAO.saveAll(Arrays.asList(daniel, adriana));
		

	}
}