package com.curso.integration;

import java.io.File;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class FiltroMensajes implements MessageSelector {

	@Override
	public boolean accept(Message<?> msg) {
		
		if(msg.getPayload() instanceof File){
			File f = (File) msg.getPayload();
			if(f.getName().startsWith("msg")){
				return true;
			}			
		}
		
		return false;
	}

}
