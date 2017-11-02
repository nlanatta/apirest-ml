package com.ml.controller;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.job.TimerTaskImp;

@RestController
@Configuration
public class JobLauncherController {

	@Autowired
	TimerTaskImp timerTaskImp;

	@RequestMapping("/jobLauncher")
	public String handle() throws Exception {
//		jobLauncher.run(customerReportJob(), new JobParametersBuilder().addLong("uniqueness", System.nanoTime()).toJobParameters());
		// timerTaskImp.execute(arg0);
		// TimerTaskImp timer = new TimerTaskImp();
		Timer timer = new Timer();
		timer.schedule(timerTaskImp, 0, 10);
		return "Success";
	}
}
