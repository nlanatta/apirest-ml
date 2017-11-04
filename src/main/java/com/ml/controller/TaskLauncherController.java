package com.ml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value = "/createAlignData", method = RequestMethod.PUT)
	public String handleSameLineData() throws Exception {
		alignDataCreator.run();
		System.out.println("ALIGN FINISHED");
		return "Wait for Data Creation Align Data";
	}
	
	@RequestMapping(value = "/createTriangleData", method = RequestMethod.POST)
	public String handleTriangleData() throws Exception {
		triangleDataCreator.run();
		System.out.println("TRIANGLE FINISHED");
		return "Wait for Data Creation Triangle Data";
	}
	
	@RequestMapping(value = "/createMaxTriangleData", method = RequestMethod.POST)
	public String handleMaxTriangleData() throws Exception {
		triangleMaxDataCreator.run();
		System.out.println("MAX TRIANGLE FINISHED");
		return "Wait for Data Creation Max Triangle Data";
	}
	
	@RequestMapping(value = "/createAlignWSunData", method = RequestMethod.POST)
	public String handleHandleSameLineWithoutSun() throws Exception {
		alignWithSunDataCreator.run();
		System.out.println("ALIGN WITH SUN FINISHED");
		return "Wait for Data Creation Align With Sun Data";
	}	
	
	@RequestMapping(value = "/createData", method = RequestMethod.POST)
	public String handleCreateData() throws Exception {
		handleSameLineData();
		handleTriangleData();
		handleMaxTriangleData();
		handleHandleSameLineWithoutSun();
		return "Wait for Data Creation";
	}
}
