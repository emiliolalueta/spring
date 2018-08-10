import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.batch_1.JobConfigCSVaConsola;
 
public class Pruebas {
 
    public static void main(String[] args) throws Exception {
    	
		AnnotationConfigApplicationContext appCtx = 
			new AnnotationConfigApplicationContext(JobConfigCSVaConsola.class);
		
        JobLauncher jobLauncher = appCtx.getBean(JobLauncher.class);
               
    	Job cochesCVSConsola = appCtx.getBean("CochesCVSConsola", Job.class);
    	JobParameters jobParameters = new JobParametersBuilder()
		.addDate("date", new Date())
		.toJobParameters();    
    	
       	JobExecution jobExecution = jobLauncher.run(cochesCVSConsola, jobParameters);

    	BatchStatus batchStatus = jobExecution.getStatus();
    	while(batchStatus.isRunning()){
    		System.out.println("Ejecutando...");
    		Thread.sleep(1000);
    	}
    	System.out.println(String.format("*********** Exit status: %s", jobExecution.getExitStatus().getExitCode()));
    	JobInstance jobInstance = jobExecution.getJobInstance();
    	System.out.println(String.format("********* Name of the job %s", jobInstance.getJobName()));
    	System.out.println("*********** job instance Id: "+ jobInstance.getId());
    	
    	
    	Thread.sleep(1000);
    	
    	
    	Job cochesCVSaXML = appCtx.getBean("CochesCVSaXML", Job.class);
    	JobParameters jobParameters2 = new JobParametersBuilder()
		.addDate("date", new Date())
		.toJobParameters();    
    	
       	JobExecution jobExecution2 = jobLauncher.run(cochesCVSaXML, jobParameters2);

    	BatchStatus batchStatus2 = jobExecution2.getStatus();
    	while(batchStatus2.isRunning()){
    		System.out.println("Ejecutando...");
    		Thread.sleep(1000);
    	}
    	System.out.println(String.format("*********** Exit status: %s", jobExecution2.getExitStatus().getExitCode()));
    	JobInstance jobInstance2 = jobExecution2.getJobInstance();
    	System.out.println(String.format("********* Name of the job %s", jobInstance2.getJobName()));
    	System.out.println("*********** job instance Id: "+ jobInstance2.getId());    	
		  	
    	
    }
 
}