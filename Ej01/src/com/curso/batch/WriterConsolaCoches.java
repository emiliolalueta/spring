package com.curso.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.CocheDTO;

@Component
public class WriterConsolaCoches implements ItemWriter<CocheDTO>{

	@Override
	public void write(List<? extends CocheDTO> datos) throws Exception {

		for(CocheDTO coche: datos){
			System.out.println(coche);
		}		
		
	}	
	
}
