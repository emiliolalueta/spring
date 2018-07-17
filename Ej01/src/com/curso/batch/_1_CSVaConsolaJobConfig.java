package com.curso.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.curso.modelo.entidad.CocheDTO;

@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages={ "com.curso" })
public class _1_CSVaConsolaJobConfig extends DefaultBatchConfigurer{

    @Override
    //En memoria
    protected JobRepository createJobRepository() throws Exception {
        MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean();
        factory.afterPropertiesSet();
        return  factory.getObject();
    }
	
    
    @Bean
    public ItemReader<CocheDTO> reader() {
        FlatFileItemReader<CocheDTO> reader = new FlatFileItemReader<CocheDTO>();
        reader.setResource(new ClassPathResource("c:/Users/elalueta/coches.csv"));	//		"e:/coches.csv"				id,marca,modelo,matricula
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
    public ItemProcessor processor() {
        return new ProcessorMayusculas();
    }    
    
    @Bean
    public Job cvs_consola(JobBuilderFactory jobs, Step step) {
       /*
    	return jobs.get("cvs_consola")
                .flow(step)
                .end()
                .build();
        */
        return jobs.get("cvs_consola")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }	   
    
	@Bean
	public Step step(StepBuilderFactory stepBuilderFactory,
	        		 ItemReader<CocheDTO> reader, 
	        		 WriterConsolaCoches writer,
	        		 ItemProcessor<CocheDTO, CocheDTO> processor) {

	    return stepBuilderFactory.get("step1")
	            .<CocheDTO, CocheDTO> chunk(2)
	            .reader(reader)
	            .processor(processor())
	            .writer((ItemWriter) writer)
	            .build();
	}	
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/bbdd");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}
	
	
}
