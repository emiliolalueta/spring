import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;
import com.curso.modelo.entidad.Coche;


public class Pruebas {

	public static void main(String[] args) {
		
		String url = "http://localhost:8080/Ej09_REST/dispatcherServlet/coches/5";
		RestTemplate rt = new RestTemplate();
		Coche c = rt.getForObject(url, Coche.class);
		System.out.println(c);
		
		url = "http://localhost:8080/Ej09_REST/dispatcherServlet/coches";
		rt.postForObject(url, c, Coche.class);
		
		url = "http://localhost:8080/Ej09_REST/dispatcherServlet/coches";
		List<Coche> coches = rt.getForObject(url, List.class);
		System.out.println(coches);
		
		url = "http://localhost:8080/Ej09_REST/dispatcherServlet/coches/{id}";
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "2");
	    c = rt.getForObject(url, Coche.class, params);
		System.out.println(c);		
		
		
		
	}
	
}
