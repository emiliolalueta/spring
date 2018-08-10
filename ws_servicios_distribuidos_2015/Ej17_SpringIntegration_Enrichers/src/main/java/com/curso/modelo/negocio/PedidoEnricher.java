package com.curso.modelo.negocio;

import org.springframework.messaging.Message;

import com.curso.modelo.entidad.Pedido;

public class PedidoEnricher {

	public int computeTotal(Message<Pedido> mensaje) {
		
		Pedido p = mensaje.getPayload();
		return p.getCantidad()*p.getPrecio();
	}

}
