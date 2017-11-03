package com.ml.task;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.ml.entity.Weather;
import com.ml.entity.WeatherCountResult;
import com.ml.repository.WeatherCountRepository;
import com.ml.repository.WeatherRepository;

public class StarsTask extends TimerTask {

	@Autowired
	WeatherRepository repo;
	
	@Autowired
	WeatherCountRepository countRepo;
	
	public static final String INTENSA_LLUVIA="INTENSA LLUVIA";
	public static final String SEQUIA="SEQUIA";
	public static final String PRESION_TEMP_OPTIMA="PRESION y TEMP OPTIMA";
	public static final String PRESION_TEMP_OPTIMA_TYPE="PRESION_TEMP_OPTIMA";
	public static final String LLUVIA="LLUVIA";

	protected int count;
	protected double firstone = 0;
	protected double secondone = 0;
	protected double thirthdone = 0;
	protected double thirthdonepos;
	protected double secondonepos;
	protected double firstonepos;
	protected double perimetro;	
	protected int countSuccess = 0;
	
	private boolean isRunning = true;
	
	protected String type = "DEFAULT";
	
	protected Hashtable<String, String> typeMap;
	
	public StarsTask() {
		typeMap = new Hashtable<String,String>();
		typeMap.put(LLUVIA, "LLUVIA");
		typeMap.put(SEQUIA, "SEQUIA");
		typeMap.put(INTENSA_LLUVIA, "INTENSA_LLUVIA");
		typeMap.put(PRESION_TEMP_OPTIMA, "PRESION_TEMP_OPTIMA");
	}

	private void checkSameAngule() {
		if (count >= 3650) {
			
			saveAmountTypeWeather();
			
			System.out.println("[[[[[[[[FINISHED]]]]]]]]]]]]]");
			setRunning(false);
			count = 0;
			this.cancel();
		}		

		firstone -= 1;
		secondone -= 3;
		thirthdone += 5;

		firstonepos = firstone + 360;
		secondonepos = secondone + 360;
		if (firstonepos >= 360) {
			firstonepos = firstonepos - 360;
		}
		if (secondone >= 360) {
			secondone = secondone - 360;
		}
		if (thirthdone >= 360) {
			thirthdone = thirthdone - 360;
		}
		if (secondone <= -360) {
			secondone = secondone + 360;
		}
		if (firstone <= -360) {
			firstone = firstone + 360;
		}

		execute();
	}

	protected void saveAmountTypeWeather() {
		countRepo.save(getWeatherCountResult(countSuccess, type, typeMap.get(type)));
	}

	protected Weather getWeather(int count2, String weatherValue) {
		Weather item = new Weather();
		item.setDayValue(count2);
		item.setWeatherValue(weatherValue);
		return item;
	}
	
	protected WeatherCountResult getWeatherCountResult(int amount, String weatherValue, String type) {
		WeatherCountResult item = new WeatherCountResult();
		item.setDayCountValue(amount);
		item.setWeatherValue(weatherValue);
		item.setWeatherType(type);
		return item;
	}
	
	protected void execute() {
	}

	@Override
	public void run() {
		setRunning(true);
		checkSameAngule();
		count +=1;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
