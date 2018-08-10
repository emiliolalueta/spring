package com.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.curso.modelo.negocio.GestorPedidos;

@SpringBootApplication
@ComponentScan(basePackages={"com.curso"/*,"com.curso.controlador","com.curso.modelo"*/})
public class Aplicacion implements CommandLineRunner{
	
	public static void main(String[] args) {
		
        ApplicationContext appCtx = SpringApplication.run(Aplicacion.class, args);
		
        String[] beanNames = appCtx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        //    System.out.println(beanName);
        }		
		
	}
	
	@Autowired
	private InicializadorBBDD inicializador;
	
	@Autowired
	private GestorPedidos gestorPedidos;
	
	@Autowired
	private PruebasEntityManager pem;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		//inicializador.inicializar();
		
		/*		
		Pedido p = new Pedido();
		p.setId(1);

		try {
			gestorPedidos.aceptar(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		*/
		
		//PRUEBAS JPA
		pem.pruebas();
		
	}
}
