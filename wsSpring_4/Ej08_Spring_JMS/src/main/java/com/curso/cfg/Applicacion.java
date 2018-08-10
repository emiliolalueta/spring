package com.curso.cfg;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//activemq start
//http://127.0.0.1:8161/admin/
//admin
//admin
public class Applicacion {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);		
		Emisor e = (Emisor) appCtx.getBean("emisor");
		e.send("cola1", "Hola Radiola");	
		e.send("cola2", "Siete caballos vienen de Bonanza");	
		
		JOptionPane.showMessageDialog(null, "Hola");
		
	}
	
}
