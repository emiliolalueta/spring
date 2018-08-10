package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
//<bean id="gestorTransportes" class="GestorTransportes" scope="singleton">
public class GestorTransportes {

	@Transactional(propagation=Propagation.REQUIRED)
	public String reservarCamion(boolean hayCamion) throws Exception{
		
		System.out.print("Reservando un camión...");
		if(!hayCamion){
			System.out.println("MAL");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
			throw new Exception("No hay camión");				
		} 
		System.out.println("OK");
		
		return "Moooc moooooc";
		
	}
	
	
}
