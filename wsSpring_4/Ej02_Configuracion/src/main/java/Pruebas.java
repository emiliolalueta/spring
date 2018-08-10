import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.negocio.ClaseGenerica;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.ordenInyeccion.GestorMensajes;

public class Pruebas {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext();
		appCtx.register(Configuracion.class);
		appCtx.refresh();
		
		System.out.println("==================================================");
		
		GestorClientes gc = (GestorClientes) appCtx.getBean("gestorClientes");
		gc.insertar("Bart");
				
		ClaseGenerica<String> cgs = (ClaseGenerica<String>) appCtx.getBean("claseGenericaString");
		System.out.println(cgs);
		cgs.add("Hola");
		
		GestorMensajes gm = (GestorMensajes) appCtx.getBean("gestorMensajes");
		gm.enviarMensaje("Ringo", "Buenos días");		
		
	}
	
}
