import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.negocio.Gestor;

public class Pruebas {

	public static void main(String[] args) {
		
		AbstractApplicationContext appCtx = 
				new AnnotationConfigApplicationContext
					(Configuracion.class);
		
		
		Gestor gestor = (Gestor) appCtx.getBean("gestor");
		gestor.insertar();
		
		appCtx.close();
		
	}
	
}
