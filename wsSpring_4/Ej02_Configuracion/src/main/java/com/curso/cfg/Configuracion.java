package com.curso.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.curso.modelo.negocio.ClaseGenerica;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.persistencia.ClienteDao;
import com.curso.modelo.persistencia.ClienteDaoJPA;

@Configuration
@ImportResource("classpath:com/curso/cfg/beans.xml")
public class Configuracion {

	@Bean(name="gestorClientes") //Lo suyo es que el método no sea un 'get'
	@Scope("singleton") 
	@Lazy
	public GestorClientes getGestorClientes(){
		
		GestorClientes gc = new GestorClientes();
		return new GestorClientes();
	}
	
	@Bean
	@Lazy
	public ClienteDao getClienteDao(){
		return new ClienteDaoJPA();
	}
	
	/*@Bean
	public ClienteDaoXML getClienteDaoXML(){
		return new ClienteDaoXML();
	}*/	
	
	@Bean
	public ClaseGenerica<String> claseGenericaString(){
		return new ClaseGenerica<String>();
	}
	
	@Bean
	public ClaseGenerica<Integer> claseGenericaInteger(){
		return new ClaseGenerica<Integer>();
	}
		
}
