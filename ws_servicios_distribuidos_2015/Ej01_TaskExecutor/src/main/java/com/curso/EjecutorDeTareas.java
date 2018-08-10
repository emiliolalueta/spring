package com.curso;

import org.springframework.core.task.TaskExecutor;

public class EjecutorDeTareas {

	private TaskExecutor taskExecutor;

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
	public void lanzarTareas(){
		
		for(int a=0; a<100; a++){
			taskExecutor.execute(new Tarea("T"+a));
		}
		System.out.println("Tareas lanzadas");
		
	}
	
	
}
