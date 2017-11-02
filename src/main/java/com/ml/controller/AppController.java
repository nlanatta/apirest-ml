package com.ml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ml.entity.Weather;
import com.ml.model.WeatherResult;
import com.ml.repository.WeatherRepository;

@RestController
public class AppController {
	
	@Autowired
	WeatherRepository repo;

    @RequestMapping("/clima")
    public WeatherResult greeting(@RequestParam(value="dia", defaultValue="1") Integer day) {
    	Weather item = repo.findByDay(day);
    	WeatherResult result = new WeatherResult(item.getDayValue(), item.getWeatherValue());
        return result;
    }
}
