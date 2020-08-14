/*//package com.br.thundersJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
	@Autowired 
	private JavaMailSender mailSender;
	  
	public void sendEmail (String sendTo) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Cadastro Realizado com Sucesso!");
        message.setText("Testado");
        message.setTo(sendTo);
        message.setFrom("thunderjava2020@gmail.com");
        
        mailSender.send(message);
        System.out.println("EMAIL ENVIADO COM SUCESSO PARA: " + sendTo);
        
	}
}*/
