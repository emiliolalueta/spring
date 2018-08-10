package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDao;

@Service
public class GestorClientes {

	@Autowired
	private ClienteDao clienteDao;
	
	public void insertar(Cliente cliente){		
		if(cliente.getTelefono()==null){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}		
		clienteDao.save(cliente);
	}
	
	public List<Cliente> listarTodos(){
		return clienteDao.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(List<Cliente> clientes){
		for(Cliente c: clientes){
			insertar(c);
		}		
		System.out.println("isRollbackOnly:"+TransactionAspectSupport.currentTransactionStatus().isRollbackOnly());
		
	}
	
}
