package com.curso.batch_2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.curso.dto.CocheDTO;
 
@Configuration
@EnableBatchProcessing
public class JobConfigCSVaXML {
 
    @Autowired
    private JobBuilderFactory jobs;
 
    @Autowired
    private StepBuilderFactory steps;
    
    @Bean
    public ItemReader<CocheDTO> readerCSVaXML() {
        FlatFileItemReader<CocheDTO> reader = new FlatFileItemReader<CocheDTO>();
        reader.setResource(new ClassPathResource("coches.csv"));
        
        //reader.setLinesToSkip(1);
        
        reader.setLineMapper(new DefaultLineMapper<CocheDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] {"id", "marca", "modelo", "matricula"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<CocheDTO>() {{
                setTargetType(CocheDTO.class);
            }});
        }});
        return reader;
    }     
    
    @Bean
    public ItemProcessor<CocheDTO, CocheDTO> processorValidacion() {
        return new ProcessorValidacion();
    }    
      
    @Bean
    public WriterXMLCoches writerXMLCoches() {
        
    	System.out.println("/////////////////////////////////////////////////////");
    	System.out.println("/////////////////////////////////////////////////////");
    	System.out.println("/////////////////////////////////////////////////////");
    	System.out.println("/////////////////////////////////////////////////////");
    	System.out.println("/////////////////////////////////////////////////////");
    	System.out.println("/////////////////////////////////////////////////////");
    	
    	return new WriterXMLCoches();
    }        
 
    @Bean
    public Job CochesCVSaXML(){
    	return jobs.get("CochesCSVaXML").start(step2()).build();
    }
 
    @Bean
    public Step step2() {
    	return steps.get("bbb")
    			.<CocheDTO, CocheDTO> chunk(5)
    			.reader(readerCSVaXML())
    			.processor(processorValidacion())
    			.writer(writerXMLCoches())
    			.build();
    }
}