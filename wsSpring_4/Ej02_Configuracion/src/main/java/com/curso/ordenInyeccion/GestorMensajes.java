package com.curso.ordenInyeccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorMensajes {

	@Autowired
	private List<EmisorMensajes> emisores;
	
	public void enviarMensaje(String destinatario, String mensaje){
		
		for(EmisorMensajes em: emisores){
			em.enviarMensaje(destinatario, mensaje);
		}
		
	}
	
}
