package com.curso.eventos;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class OyenteContextoSpring3 
	implements ApplicationListener<ApplicationEvent>{

	public OyenteContextoSpring3() {
		super();
		System.out.println("Creando OyenteContextoSpring3");
	}

	@Override
	public void onApplicationEvent(ApplicationEvent ev) {
		
		if(ev instanceof ContextRefreshedEvent){
			System.out.println("AppCtx creado Spring3");
		} else if(ev instanceof ContextClosedEvent){
			System.out.println("Hasta luego Lucas Spring3");
		}
		
	}

}
