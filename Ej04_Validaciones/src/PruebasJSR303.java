import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.curso.modelo.entidad.Pelicula;

public class PruebasJSR303 {

	public static void main(String[] args) {
		
		Validator validador = 
			Validation.buildDefaultValidatorFactory().getValidator();
		
		Pelicula p = new Pelicula(1,"","","",1899);
		
		Set<ConstraintViolation<Pelicula>> errores = validador.validate(p);
		for(ConstraintViolation<Pelicula> error: errores){
			System.out.println(error.getMessage());
			System.out.println(error.getPropertyPath());			
		}
		
		System.out.println("Finn");
		
		
		
	}
	
}




