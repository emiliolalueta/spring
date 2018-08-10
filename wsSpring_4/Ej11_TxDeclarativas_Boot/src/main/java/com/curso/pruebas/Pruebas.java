package com.curso.pruebas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.pruebas.PruebasJPA;

public class Pruebas {

	public static void main(String[] args) {
		
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans.xml");
			
		
		//PruebasJPA pruebasJPA = (PruebasJPA) appCtx.getBean("pruebasJPA");
		//pruebasJPA.insertar();		
		//pruebasJPA.cargasPerezosas();
		
		CrearBaseDeDatos cbd = (CrearBaseDeDatos) appCtx.getBean("crearBaseDeDatos");
		cbd.insertar();
		
		
	}
	
}
