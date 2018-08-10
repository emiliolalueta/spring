package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.curso.eventos.Evento;

@Service
public class Gestor {

	@Autowired
	private ApplicationEventPublisher appEventPublisher;
	
	public void insertar(){
		
		//LN
		
		appEventPublisher.publishEvent(new Evento("Evento",350));
		
	}
	
}
