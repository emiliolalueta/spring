package com.curso.cfg;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EntornoDesarrolloCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String entorno = context.getEnvironment().getProperty("entorno");
		return entorno.equalsIgnoreCase("desarrollo");
	}

}