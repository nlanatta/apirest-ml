package com.ml.task;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

import com.ml.entity.Weather;
import com.ml.model.MaxWeatherResult;

@Component
public class MaxTriangleStarsTask extends StarsTask {

	private Hashtable<Double, MaxWeatherResult> perimeters;
	
	public MaxTriangleStarsTask() {
		super.type = StarsTask.INTENSA_LLUVIA;
		perimeters = new Hashtable<>();
	}	
	
	@Override
	protected void execute() {

		double x1 = 500 * Math.cos(firstonepos);
		double y1 = 500 * Math.sin(firstonepos);
		double x2 = 2000 * Math.cos(secondonepos);
		double y2 = 2000 * Math.sin(secondonepos);
		double x3 = 1000 * Math.cos(thirthdone);
		double y3 = 1000 * Math.sin(thirthdone);

		double l1 = 0;
		double l2 = 0;
		double l3 = 0;
		
		if (((firstonepos - secondonepos) >= 135 || (firstonepos - secondonepos) <= -135)
				&& ((firstonepos - thirthdone) >= 140 || (firstonepos - thirthdone) <= -140)
				&& ((secondonepos - thirthdone) >= 90 || (thirthdone - secondonepos) >= 90)) {

			l1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
			l2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
			l3 = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));

			perimetro = l1 + l2 + l3;
			System.out.println("perimetro : " + perimetro);
			
			MaxWeatherResult resultWeather = new MaxWeatherResult();
			resultWeather.setDayCountValue(count);
			resultWeather.setWeatherValue(type);
			resultWeather.setWeatherType(typeMap.get(type));
			perimeters.put(perimetro, resultWeather);
			
			System.out.println(
					"[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[["+StarsTask.INTENSA_LLUVIA+"]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println("////////////////////");
			System.out.println("Day :" + count);
			System.out.println("firstone :" + firstonepos);
			System.out.println("secondone :" + secondonepos);
			System.out.println("thirthdone :" + thirthdone);
			
		}
	}
	
	@Override
	protected void saveAmountTypeWeather() {
		double max = Collections.max((Collection<Double>) perimeters.keySet());
		MaxWeatherResult result = perimeters.get(max);
		countRepo.save(getWeatherCountResult(1, type, typeMap.get(type)));
		Weather wresult = repo.findByDay(result.getDayCountValue());
		if(wresult != null) {
			repo.delete(wresult);
		}
		repo.save(getWeather(result.getDayCountValue(), result.getWeatherValue()));		
	}
}
