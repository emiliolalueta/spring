package com.curso.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.CocheDTO;

@Component
public class ReaderListaCoches implements ItemReader<CocheDTO>{

	private List<CocheDTO> datos;
	private int pos;
	
	public void setDatos(List<CocheDTO> datos){
		this.datos = datos;
	}
	
	public ReaderListaCoches(){
		List<CocheDTO> coches = new ArrayList<CocheDTO>();
		coches.add(new CocheDTO(1,"Marca1","Modelo1","M-1"));
		coches.add(new CocheDTO(2,"Marca2","Modelo2","M-2"));
		coches.add(new CocheDTO(3,"Marca3","Modelo3","M-3"));
		coches.add(new CocheDTO(4,"Marca4","Modelo4","M-4"));
		coches.add(new CocheDTO(5,"Marca5","Modelo5","M-5"));
		coches.add(new CocheDTO(6,"Marca6","Modelo6","M-6"));
		coches.add(new CocheDTO(7,"Marca7","Modelo7","M-7"));		
	}
	
	@Override
	public CocheDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		CocheDTO coche = null;
		
		if(pos<datos.size()){
			coche = datos.get(pos);
			pos++;
		}	
		
		return coche;
	}

}
