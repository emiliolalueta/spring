package com.curso.batch_1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
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
@ComponentScan(basePackages={ "com.curso" })
public class JobConfigCSVaConsola {
 
    @Autowired
    private JobBuilderFactory jobs;
 
    @Autowired
    private StepBuilderFactory steps;
    
    @Bean
    public ItemReader<CocheDTO> readerCSVaConsola() {
        FlatFileItemReader<CocheDTO> reader = new FlatFileItemReader<CocheDTO>();
        reader.setResource(new ClassPathResource("coches.csv"));
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
    public ItemProcessor<CocheDTO, CocheDTO> processorMayusculas() {
        return new ProcessorMayusculas();
    }    
        
    @Bean
    public WriterConsolaCoches writerConsolaCoches() {
        return new WriterConsolaCoches();
    }        
 
    @Bean
    public Job CochesCVSConsola(){
    	return jobs.get("CochesCVSConsola").start(step()).build();
    }
 
    @Bean
    public Step step() {
    	return steps.get("aaa")
    			.<CocheDTO, CocheDTO> chunk(5)
    			.reader(readerCSVaConsola())
    			.processor(processorMayusculas())
    			.writer(writerConsolaCoches())
    			.build();
    }

}

