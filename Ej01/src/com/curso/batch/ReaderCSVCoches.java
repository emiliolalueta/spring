package com.curso.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.CocheDTO;

//@Component
public class ReaderCSVCoches extends FlatFileItemReader<CocheDTO>{

	public ReaderCSVCoches() {
		this.setResource(new ClassPathResource("e:/coches.csv"));
		
		///////////////////////
		this.setLinesToSkip(1);
		///////////////////////
		
		LineMapper<CocheDTO> cocheLineMapper = createCocheLineMapper();
		this.setLineMapper(cocheLineMapper);
	}
 
    private LineMapper<CocheDTO> createCocheLineMapper() {
        DefaultLineMapper<CocheDTO> cocheLineMapper = new DefaultLineMapper<>();
 
        LineTokenizer cocheLineTokenizer = createCocheLineTokenizer();
        cocheLineMapper.setLineTokenizer(cocheLineTokenizer);
 
        FieldSetMapper<CocheDTO> cocheInformationMapper = createCocheInformationMapper();
        cocheLineMapper.setFieldSetMapper(cocheInformationMapper);
 
        return cocheLineMapper;
    }
	
    private LineTokenizer createCocheLineTokenizer() {
        DelimitedLineTokenizer cocheLineTokenizer = new DelimitedLineTokenizer();
        cocheLineTokenizer.setDelimiter(";");
        cocheLineTokenizer.setNames(new String[]{"id", "marca", "modelo", "matricula"});
        return cocheLineTokenizer;
    }
 
    private FieldSetMapper<CocheDTO> createCocheInformationMapper() {
        BeanWrapperFieldSetMapper<CocheDTO> cocheInformationMapper = new BeanWrapperFieldSetMapper<>();
        cocheInformationMapper.setTargetType(CocheDTO.class);
        return cocheInformationMapper;
    }    
	
	
}
