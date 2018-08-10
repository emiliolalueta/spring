package com.curso.modelo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CronometroAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {

		mi.getMethod();     //Método que se está invocando
		mi.getArguments();  //Parametros
		mi.getStaticPart(); //Target
		
		long inicio = System.currentTimeMillis();
		
		Object retorno = mi.proceed();
		
		long fin = System.currentTimeMillis();
		System.out.println("Metodo "+mi.getMethod().getName()+" ejecutado en "+(fin-inicio)+" milisegundos");
		
		return retorno;
	}


	
	
}
