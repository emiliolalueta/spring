package com.curso.sesion.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.curso.sesion.modelo.Detalle;

//@Component
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
/*
<bean id="YOUR_BEAN_ID" class="YOUR_FULLY_QUALIFIED_CLASSNAME" scope="prototype">
    <aop:scoped-proxy proxy-target-class="true"/>
</bean>
 */
public class PedidoProxy {

	private List<Detalle> detalles = new ArrayList<Detalle>();

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
}
