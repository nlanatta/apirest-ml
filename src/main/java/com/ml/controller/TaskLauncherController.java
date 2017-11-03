package com.ml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.App;
import com.ml.task.AlignDataCreator;
import com.ml.task.AlignStarsWithSunDataCreator;
import com.ml.task.MaxTriangleDataCreator;
import com.ml.task.TriangleDataCreator;

@RestController
@Configuration
public class TaskLauncherController {

	@Autowired
	@Qualifier("alignDataCreator")
	AlignDataCreator alignDataCreator;
	
	@Autowired
	@Qualifier("alignStarsWithSunDataCreator")
	AlignStarsWithSunDataCreator alignWithSunDataCreator;
	
	@Autowired
	TriangleDataCreator triangleDataCreator;
	
	@Autowired
	MaxTriangleDataCreator triangleMaxDataCreator;

	@RequestMapping(value = "/createData", method = RequestMethod.PUT)
	public String handle() throws Exception {
		executeTasks();		
		return "Success";
	}
	
	private void executeTasks() {
		alignDataCreator.run();
		System.out.println("ALIGN FINISHED");
		
		alignWithSunDataCreator.run();
		System.out.println("ALIGN WITH SUN FINISHED");
		
		triangleDataCreator.run();
		System.out.println("TRIANGLE FINISHED");
		
		triangleMaxDataCreator.run();
		System.out.println("MAX TRIANGLE FINISHED");
	}
}
