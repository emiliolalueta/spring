package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDao;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GestorClientes implements ApplicationContextAware{

	@Autowired
	private ClienteDao clienteDao;

	private GestorClientes proxy;
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx) throws BeansException {
		proxy = appCtx.getBean(GestorClientes.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insertar(Cliente cliente){
		
		if(cliente.getNombre()==null){
			//ZASCA
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		clienteDao.insertar(cliente);
	}
	
	public void insertarClientes(List<Cliente> clientes){

		for(Cliente c: clientes){
			proxy.insertar(c);
		}
		
	}
	
	public List<Cliente> listarTodos(){
		return clienteDao.listarTodos();		
	}


	
}
