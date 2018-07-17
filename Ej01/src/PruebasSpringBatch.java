import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.batch._1_CSVaConsolaJobConfig;

public class PruebasSpringBatch {

	public static void main(String[] args) throws Exception{
		
		AnnotationConfigApplicationContext appCtx = 
			new AnnotationConfigApplicationContext(_1_CSVaConsolaJobConfig.class);
		
		//Se pueden añadir nuevas clases anotadas con @Configuration
		//en cualquier momento
		//appCtx.register(Configuracion.class);
		//appCtx.refresh();
		
        JobLauncher jobLauncher = appCtx.getBean(JobLauncher.class);
    	Job addNewPodcastJob = appCtx.getBean("cvs_consola", Job.class);
    	JobParameters jobParameters = new JobParametersBuilder()
		.addDate("date", new Date())
		.toJobParameters();  

    	JobExecution jobExecution = jobLauncher.run(addNewPodcastJob, jobParameters);

    	BatchStatus batchStatus = jobExecution.getStatus();
    	while(batchStatus.isRunning()){
    		System.out.println("Ejecutando...");
    		Thread.sleep(1000);
    	}
    	System.out.println(String.format("*********** Exit status: %s", jobExecution.getExitStatus().getExitCode()));
    	JobInstance jobInstance = jobExecution.getJobInstance();
    	System.out.println(String.format("********* Name of the job %s", jobInstance.getJobName()));

    	System.out.println("*********** job instance Id: "+ jobInstance.getId());
		
		
	}
	
}
