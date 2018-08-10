package com.curso.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.curso.eventos.OyenteContextoSpring3;
import com.curso.eventos.OyenteContextoSpring4;

@Configuration
@ImportResource("classpath:com/curso/cfg/beans.xml")
@ComponentScan(basePackages={ "com.curso"})
public class Configuracion {
/*
	@Bean
	public OyenteContextoSpring3 oyenteContextoSpring3(){
		return new OyenteContextoSpring3();
	}	

	@Bean
	public OyenteContextoSpring4 oyenteContextoSpring4(){
		return new OyenteContextoSpring4();
	}	
*/	
}
