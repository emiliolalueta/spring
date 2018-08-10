package com.curso.ordenInyeccion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class EmisorMensajesCorreoE implements EmisorMensajes{

	@Override
	public void enviarMensaje(String destinatario, String mensaje) {
		System.out.println("Enviando correoE a "+destinatario);
	}

}
