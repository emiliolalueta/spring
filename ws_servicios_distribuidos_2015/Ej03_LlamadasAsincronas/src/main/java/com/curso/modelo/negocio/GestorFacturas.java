package com.curso.modelo.negocio;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class GestorFacturas {

	public void metodo1(){		
		System.out.println("Iniciando metodo1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin metodo1");		
	}

	@Async
	public void metodo2(){		
		System.out.println("Iniciando metodo2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin metodo2");
	}	
	
	@Async
	public Future<String> metodo3(Date fechaInicio, Date fechaFin){		
		System.out.println("Iniciando metodo3");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin metodo3");	
		
		return new AsyncResult<String>("FACTURITAS RICAS");
	}
	
	
	
	
}
