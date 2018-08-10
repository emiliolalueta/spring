package com.curso.eventos;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OyenteContextoSpring4 {

	@EventListener
	public void oyenteInicializacion(ContextRefreshedEvent ev){
		System.out.println("AppCtx creado Spring4");
	}
	
	@EventListener
	public void oyenteInicializacion(ContextClosedEvent ev){
		System.out.println("Hasta luego Lucas Spring4");
	}
	
}
