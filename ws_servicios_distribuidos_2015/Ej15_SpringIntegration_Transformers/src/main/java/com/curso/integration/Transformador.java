package com.curso.integration;

import java.util.Scanner;

import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Transformador {

	@Transformer
	public Message<String> transformar(Message<String> mensajeEntrada) {

		String texto = mensajeEntrada.getPayload();
		return MessageBuilder.withPayload(texto.toUpperCase()).build();
	}
}
