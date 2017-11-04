package com.ml.task;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DestroyTasks {
	
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
	
	public DestroyTasks() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				boolean isFinished = alignWithSunDataCreator.finish() &&
									 alignWithSunDataCreator.finish() &&
									 triangleDataCreator.finish() &&
									 triangleMaxDataCreator.finish();
				if(isFinished) {
					this.cancel();
				}
			}
		}, 1000);
	}
}
