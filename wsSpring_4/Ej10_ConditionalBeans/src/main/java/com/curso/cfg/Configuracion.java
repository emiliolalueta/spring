package com.curso.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.curso.modelo.negocio.Servicio;
import com.curso.modelo.negocio.ServicioImplDesarrollo;
import com.curso.modelo.negocio.ServicioImplProduccion;

@Configuration
@PropertySource("classpath:/com/curso/cfg/aplicacion.properties")
public class Configuracion {

	@Bean(name="servicio")
	@Conditional(value=EntornoDesarrolloCondition.class)	
	public Servicio servicioImplDeasarrollo(){
		return new ServicioImplDesarrollo();
	}
	
	@Bean(name="servicio")
	@Conditional(value=EntornoProduccionCondition.class)	
	public Servicio servicioImplProduccion(){
		return new ServicioImplProduccion();
	}
	
}
