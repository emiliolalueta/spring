

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.negocio.Servicio;

public class Applicacion {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		Servicio servicio = (Servicio) appCtx.getBean("servicio");
		servicio.metodo();		
		
	}
	
}
