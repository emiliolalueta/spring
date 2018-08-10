package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

//Sin interfaz
public class GestorEmpleados {
	
	//private EmpleadoDao empleadoDao;
	
	public void insertar(String empleado){
		System.out.println("Insertando el empleado "+empleado+" en el GESTOR");
		//LN
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
	
	public void borrar(String empleado){
		System.out.println("Borrando el empleado "+empleado+" en el GESTOR");
		//LN
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
}
