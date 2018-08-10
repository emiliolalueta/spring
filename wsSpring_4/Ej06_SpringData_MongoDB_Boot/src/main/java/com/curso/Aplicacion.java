package com.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.curso.modelo.entidad.Director;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.DirectorDao;
import com.curso.modelo.persistencia.PeliculaDao;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner {

	public static void main(String[] args) {
		//SpringApplication.run(Aplicacion.class, args);
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Aplicacion.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}

	
	@Autowired
	private PeliculaDao peliculaDao;
	@Autowired
	private DirectorDao directorDao;
	
	@Override
	public void run(String... arg0) throws Exception {
				
		Director d = new Director(1,"Ridley Scott");
		Pelicula p1 = new Pelicula(1, "Alien", 1979, "cifi", d);
		Pelicula p2 = new Pelicula(2, "Blade Runner", 1981, "cifi", d);
		Pelicula p3 = new Pelicula(3, "Die Hard", 1988, "accion", null);
		
		//directorDao.insert(d);
		//peliculaDao.insert(p1);
		//peliculaDao.insert(p2);
		//peliculaDao.insert(p3);
				
		Pelicula p1b = peliculaDao.findOne(1);
		Pelicula p2b = peliculaDao.findOne(2);
		
		System.out.println(p1b.getDirector());
		System.out.println(p2b.getDirector());
		
		
		List<Pelicula> peliculas = peliculaDao.findAll();
		for(Pelicula p: peliculas){
			System.out.println(p.getTitulo()+","+p.getDirector());			
		}
		
		List<Pelicula> peliculas2 = peliculaDao.findByGeneroOrYear("cifi", 1978);
		for(Pelicula p: peliculas2){
			System.out.println(p.getTitulo()+","+p.getDirector());			
		}
		
		
		
		System.out.println(peliculaDao.count());		
		
	}
}
