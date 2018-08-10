package com.curso;

import java.util.Arrays;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.persistencia.ClienteDao;

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
	private GestorClientes gestorClientes;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("Iniciado");
		
		//gestorClientes.insertar(new Cliente(null,"N9","Santa Pola","T2"));

		System.out.println("================================");
		for(Cliente cAux: clienteDao.findByDireccionOrTelefono("Santa Pola","923")){
			System.out.println(cAux.getNombre());
		}
		System.out.println("================================");
		for(Cliente cAux: clienteDao.findAllOrderByDireccion()){
			System.out.println(cAux.getNombre()+","+cAux.getDireccion());
		}
				
		
	}
}
