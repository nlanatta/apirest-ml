package com.ml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ml.entity.Weather;
import com.ml.entity.WeatherCountResult;
import com.ml.model.MaxWeatherResult;
import com.ml.model.WeatherResult;
import com.ml.repository.WeatherCountRepository;
import com.ml.repository.WeatherRepository;
import com.ml.task.StarsTask;

@RestController
public class AppController {

	@Autowired
	WeatherRepository repo;

	@Autowired
	WeatherCountRepository countRepo;

	@RequestMapping("/clima")
	public WeatherResult weather(@RequestParam(value = "dia", defaultValue = "1") Integer day) {
		WeatherResult result;
		try {
			Weather item = repo.findByDay(day);
			result = new WeatherResult(item.getDayValue(), item.getWeatherValue());
		} catch (Exception e) {
			result = new WeatherResult(day, "NOTHING FOR THAT DAY");
		}
		return result;
	}

	@RequestMapping("/clima/sequia")
	public MaxWeatherResult norain() {
		WeatherCountResult item = countRepo.findByType(StarsTask.SEQUIA);
		MaxWeatherResult result = new MaxWeatherResult();
		result.setDayCountValue(item.getDayCountValue());
		result.setWeatherValue(item.getWeatherValue());
		result.setWeatherType(item.getWeatherType());
		return result;
	}

	@RequestMapping("/clima/lluvia")
	public MaxWeatherResult rain() {
		WeatherCountResult item = countRepo.findByType(StarsTask.LLUVIA);
		MaxWeatherResult result = new MaxWeatherResult();
		result.setDayCountValue(item.getDayCountValue());
		result.setWeatherValue(item.getWeatherValue());
		result.setWeatherType(item.getWeatherType());
		return result;
	}

	@RequestMapping("/clima/maxlluvia")
	public WeatherResult maxrain() {
		Weather item = repo.findByValue(StarsTask.INTENSA_LLUVIA);
		WeatherResult result = new WeatherResult(item.getDayValue(), item.getWeatherValue());
		return result;
	}

	@RequestMapping("/clima/optimo")
	public MaxWeatherResult greatcond() {
		WeatherCountResult item = countRepo.findByType(StarsTask.PRESION_TEMP_OPTIMA_TYPE);
		MaxWeatherResult result = new MaxWeatherResult();
		result.setDayCountValue(item.getDayCountValue());
		result.setWeatherValue(item.getWeatherValue());
		result.setWeatherType(item.getWeatherType());
		return result;
	}
}
