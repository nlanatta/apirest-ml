package com.ml.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.job.TimerTaskImp;

@RestController
@Configuration
public class JobLauncherController {
	@Autowired
	private JobBuilderFactory jobBuilders;

	@Autowired
	private StepBuilderFactory stepBuilders;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	TimerTaskImp timerTaskImp;

	private static final String JOB_NAME = "customerReportJob";
	public static final String TASKLET_STEP = "taskletStep";

	@RequestMapping("/jobLauncher")
	public String handle() throws Exception {
		jobLauncher.run(customerReportJob(), new JobParametersBuilder().addLong("uniqueness", System.nanoTime()).toJobParameters());
		// timerTaskImp.execute(arg0);
		// TimerTaskImp timer = new TimerTaskImp();

		return "Success";
	}

	@Bean
	public Job customerReportJob() {
		return jobBuilders.get("test").start(taskletStep()).build();
	}

	@Bean
	public Step taskletStep() {
		return stepBuilders.get(TASKLET_STEP).tasklet(tasklet()).build();
	}

	@Bean
	public Tasklet tasklet() {
		return (contribution, chunkContext) -> {
//			log.info("Executing tasklet step");
			return RepeatStatus.FINISHED;
		};
	}

	// @Bean
	// public JobLauncher getJobLauncher() throws Exception {
	// SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
	// jobLauncher.setJobRepository(null);
	// jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
	// jobLauncher.afterPropertiesSet();
	// return jobLauncher;
	// }

	// @Bean
	// public Job customerReportJob() {
	// return jobBuilders.get("customerReportJob")
	// .start(taskletStep())
	// .build();
	// }
	//
	// @Bean
	// public Step taskletStep() {
	// return stepBuilders.get("taskletStep")
	// .tasklet(tasklet())
	// .build();
	// }
	//
	// @Bean
	// public Tasklet tasklet() {
	// return (contribution, chunkContext) -> {
	// return RepeatStatus.FINISHED;
	// };
	// }

	// @Bean
	// @Override
	// public JobRepository getJobRepository() throws Exception {
	// JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
	// factory.setDataSource(dataSource);
	// factory.setTransactionManager(getTransactionManager());
	// factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
	// factory.setValidateTransactionState(false);
	// factory.afterPropertiesSet();
	// return factory.getObject();
	// }
}
