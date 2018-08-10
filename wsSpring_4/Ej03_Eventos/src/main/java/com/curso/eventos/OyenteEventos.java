package com.curso.eventos;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OyenteEventos {

	@EventListener(condition = "#ev.dato2>=250")
	public void onEvento1(Evento ev){
		System.out.println("Evento recibido >=250:"+ev);
	}

	@EventListener(condition = "#ev.dato2<250")
	public void onEvento2(Evento ev){
		System.out.println("Evento recibido <250:"+ev);
	}
	
}
