package com.curso.ordenInyeccion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class EmisorMensajesSMS implements EmisorMensajes{

	@Override
	public void enviarMensaje(String destinatario, String mensaje) {
		System.out.println("Enviando SMS a "+destinatario);
	}

}
