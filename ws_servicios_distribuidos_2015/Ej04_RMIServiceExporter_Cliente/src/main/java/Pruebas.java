import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Coche;
import com.curso.modelo.negocio.ServicioCoches;


//Pruebas de TaskScheduler con configuracion XM
public class Pruebas {

	public static void main(String[] args) {		
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("====================================");
		
		ServicioCoches servicioCoches = 
				(ServicioCoches) appCtx.getBean("servicioCoches"); 
		
		servicioCoches.insertar(new Coche("Renault","8","M"));
		List<Coche> coches = servicioCoches.listarTodos();
		for(Coche c: coches){
			System.out.println(c);
		}
		
		
	}
	
	
}
