import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.negocio.GestorFacturas;


public class Pruebas {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("====================================");

		GestorFacturas gf = (GestorFacturas) appCtx.getBean("gestorFacturas");
		GestorFacturas gf1 = (GestorFacturas) appCtx.getBean("gestorFacturas");
		GestorFacturas gf2 = (GestorFacturas) appCtx.getBean("gestorFacturas");
		
		System.out.println(gf);
		System.out.println(gf1);
		System.out.println(gf2);
		
		System.out.println("====================================");
		System.out.println("MAIN-1");
		gf.metodo1();
		System.out.println("MAIN-2");
		gf.metodo2();
		System.out.println("MAIN-3");
		
		Future<String> facturas = gf.metodo3(null, null);
		
		try {
			System.out.println(facturas.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("MAIN-4");
		
		
		
		
	}
	
}
