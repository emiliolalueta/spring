import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Coche;
import com.curso.modelo.servicio.ServicioCoches;


public class PruebasCliente {

	public static void main(String[] args) {
		
		System.out.println("HESSIAN");
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
		
		ServicioCoches servicioCoches = (ServicioCoches) appCtx.getBean("servicioCoches");
		Coche coche = new Coche("Reanult","8","M-790000");
		servicioCoches.insertar(coche);
		for(Coche c: servicioCoches.listar()){
			System.out.println(c);
		}	
		
	}
	
}
