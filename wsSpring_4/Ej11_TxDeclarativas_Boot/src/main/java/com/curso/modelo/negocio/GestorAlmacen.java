package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GestorAlmacen {

	@Autowired private ProductoDAO productoDAO;
	
	public void comprobarExistencias(Producto producto, Integer cantidad) throws Exception{
		
		producto = productoDAO.buscar(producto.getId());
		
		System.out.print("comprobando las existencias del producto "+producto.getNombre()+"...");
		if(producto.getExistencias()<cantidad){
			System.out.println("MAL");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
			//throw new Exception("No hay existencias");		
		} 

		System.out.println("OK");
				
	}
	
	public void reducirExistencias(Producto producto, Integer cantidad){
		
		producto = productoDAO.buscar(producto.getId());
		producto.setExistencias(producto.getExistencias()-cantidad);
		productoDAO.modificar(producto);		
		
	}
	
}








