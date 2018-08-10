package com.curso.modelo.aop;

import java.lang.reflect.Method;
import java.util.Date;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class LogAdvice implements MethodBeforeAdvice, AfterReturningAdvice{

	@Override
	public void before(Method metodo, Object[] parametros, Object target) throws Throwable {
		System.out.println("Log: Llamada al metodo "+metodo.getName()+". "+new Date());
	}

	@Override
	public void afterReturning(Object retorno, Method metodo, Object[] parametros, Object target) throws Throwable {
		//
	}
	
}
