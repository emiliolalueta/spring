package com.curso.pruebas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorPedidos;

public class PruebasAceptarPedido {

	public static void main(String[] args) {
		
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans.xml");
			

		GestorPedidos gp = (GestorPedidos) appCtx.getBean("gestorPedidos");		
		Pedido p = new Pedido();
		p.setId(1);		
		
		try {
			gp.aceptar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
