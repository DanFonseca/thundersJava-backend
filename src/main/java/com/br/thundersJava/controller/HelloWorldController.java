//package com.br.thundersJava.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.br.thundersJava.services.SendMailService;
//
//@RestController
//@CrossOrigin("*")
//public class HelloWorldController {
//	
//	//instanciando a classe para envio de email.
//	@Autowired
//	private SendMailService sendMail;
//	
//	@GetMapping("/teste")
//	public ResponseEntity<String> helloWorld(){
//		
//		sendMail.sendEmail("daniel.freitas.ms1@gmail.com");
//		
//		return ResponseEntity.ok().body("Hello World!");
//	}
//}
