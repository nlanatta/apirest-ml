package com.ml.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLauncherController {
	
    @Autowired
    Job timerTaskImp;
	
	@RequestMapping("/jobLauncher")
    public void handle() throws Exception{
		getJobLauncher().run(timerTaskImp, new JobParameters());
    }
	
	@Bean
	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(null); 
		jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor()); 
		jobLauncher.afterPropertiesSet(); 
		return jobLauncher;
	}
	
//	@Bean 
//	 @Override 
//	 public JobRepository getJobRepository() throws Exception { 
//	  JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean(); 
//	  factory.setDataSource(dataSource); 
//	  factory.setTransactionManager(getTransactionManager()); 
//	  factory.setIsolationLevelForCreate("ISOLATION_DEFAULT"); 
//	  factory.setValidateTransactionState(false); 
//	  factory.afterPropertiesSet(); 
//	  return factory.getObject(); 
//	 } 
}
