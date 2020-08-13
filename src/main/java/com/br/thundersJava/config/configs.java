package com.br.thundersJava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
		Gerente daniel = new Gerente(0,"daniel","987312845", "dafrefo", "123", "daniel.jpeg");
		Gerente adriana = new Gerente(0,"adriana","912365785", "asgasdc", "456", "adriana.jpeg");
		
		//criando cadastro de agencias.
		Agencia mooca = new Agencia(0,"Itaú Mooca","09:00","14:00");
		Agencia interlagos = new Agencia(0,"Itaú Interlagos","09:00","14:00");
		Agencia jabaquara = new Agencia(0,"Itaú Jabaquara","09:00","14:00");
		Agencia morumbi = new Agencia(0,"Itaú Morumbi","09:00","14:00");
		
		agenciaDAO.saveAll(Arrays.asList(mooca, interlagos, jabaquara, morumbi));
		
		//Cirando os Agendamentos
		Agendamento jorge = new Agendamento(0, sdf.parse("2020-10-15"), "09:00", "Tirar Extrato Bancário", interlagos, "Jorge Rodrigues", "jorge@ggmail.com", "(11)95873-0053" );
		Agendamento cecilia = new Agendamento(0, sdf.parse("2020-10-18"), "11:00", "Trocar conta bancária", morumbi, "Cecilia Meira", "Cecilia@ggmail.com", "(11)94893-5813" );
		Agendamento pedro = new Agendamento(0, sdf.parse("2020-10-17"), "13:00", "Abrir Conta", mooca, "Pedro", "pedro_ribeiro@gmail.com", "(11)97841-3214" );
		Agendamento marcela = new Agendamento(0, sdf.parse("2020-10-03"), "14:00", "Recuperar a senha do cartão de crédito", jabaquara, "Marcela", "marcela.moreira@outlook.com", "(11)95213-6931" );
		Agendamento paloma = new Agendamento(0, sdf.parse("2020-08-25"), "12:30", "Falar com meu Gerente", mooca, "Paloma Wadovski", "paloma.wadovski@gmail.com", "(11)94523-9874" );
		Agendamento douglas = new Agendamento(0, sdf.parse("2020-09-02"), "13:25", "Investir em ações ITAÚSA", interlagos, "Douglas Oliveira", "douglas.oliveira@outlook.com", "(11)98523-5476" );
		
		
		agendamentoDAO.saveAll(Arrays.asList(jorge, cecilia, pedro, marcela,paloma, douglas));
		
		gerenteDAO.saveAll(Arrays.asList(daniel, adriana));
		

	}
}