package ejemplo_hilos;

import java.util.Date;

public class GestorFacturas implements Runnable{

	//Por culpa de estos atributos esta clase no es thread safe
	private Date fechaInicio;
	private Date fechaFin;
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	//////////////////////////////////////
	
	public void insertar(String factura){
	}
	
	public void modificar(String factura){
	}
	
	public void borrar(String factura){
	}

	@Override
	public void run() {

		System.out.println("Ejecutando la facturación mensual");
		//
		//Aqui se usan las fechas de inicio y fin
		//
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Facturación creada");
		
	}
	
	
	
	
	
	
	
}
