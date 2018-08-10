import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.negocio.GestorEmpleados;

public class PruebasAutoProxy {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/curso/cfg/beansAutoproxy.xml");
		
		GestorClientes gc = (GestorClientes) appCtx.getBean("gestorClientes");
		GestorEmpleados ge = (GestorEmpleados) appCtx.getBean("gestorEmpleados");
		
		Cliente c = new Cliente("Bart");
		gc.insertar(c);
		gc.borrar(c);

		ge.insertar("Bender");
		ge.borrar("Bender");
		
	}
	
}
