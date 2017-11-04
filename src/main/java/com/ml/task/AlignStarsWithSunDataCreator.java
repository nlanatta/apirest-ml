package com.ml.task;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("alignStarsWithSunDataCreator")
public class AlignStarsWithSunDataCreator implements Runnable {

	@Autowired
	@Qualifier("alignStarsWithSunTask")
	AlignStarsWithSunTask timerTask;

	@Override
	public void run() {
		Timer timer = new Timer();
		timer.schedule(timerTask, 0, 10);
	}

	public boolean finish() {
		if (!timerTask.isRunning()) {
			try {
				this.finalize();
				return true;
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
