package com.curso.modelo.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJPADAO<T, K> implements InterfaceDAO<T, K> {

	@SuppressWarnings("unchecked")
	private Class<T> tipo = (Class<T>)
			                ((ParameterizedType)									
			                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@PersistenceContext(unitName="mysqlPU")
	protected EntityManager em;
	
	@Override
	public void insertar(T obj){
		em.persist(obj);
	}
	
	@Override
	public void modificar(T obj){
		em.merge(obj);
	}
	
	@Override
	public void borrar(T obj){
		obj = em.merge(obj);
		em.remove(obj);
	}	
	
	@Override
	public T buscar(K id){
		return (T) em.find(tipo, id);
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> listarTodos(){
		return em.createQuery("select o from "+tipo.getName()+" o").getResultList();
	}	
	
}









