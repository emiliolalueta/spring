import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.ws.Coche;
import com.curso.ws.ServicioCoches;


public class Pruebas {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
		
		ServicioCoches sc = (ServicioCoches) appCtx.getBean("servicioCoches");
		
		Coche c = new Coche();
		c.setMarca("Ford");
		c.setModelo("Focus");
		c.setMatricula("1234JQK");
		sc.insertar(c);
		
		List<Coche> coches = sc.listarTodos();
		for(Coche cAux: coches){
			System.out.println(cAux);
		}		
		
	}
	
}
