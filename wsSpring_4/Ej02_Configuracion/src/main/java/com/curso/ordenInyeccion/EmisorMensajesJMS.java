package com.curso.ordenInyeccion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class EmisorMensajesJMS implements EmisorMensajes{

	@Override
	public void enviarMensaje(String destinatario, String mensaje) {
		System.out.println("Enviando JMS a "+destinatario);
	}

}
