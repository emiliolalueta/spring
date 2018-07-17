package com.curso.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.CocheDTO;

@Component
public class ProcessorValidacion implements ItemProcessor<CocheDTO, CocheDTO> {

	@Override
	public CocheDTO process(CocheDTO coche) throws Exception {
		if(coche.getMarca() == null){
			return null;
		}
		
		return coche;
	}

}
