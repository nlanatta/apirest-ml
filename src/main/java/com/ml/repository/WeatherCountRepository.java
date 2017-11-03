package com.ml.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ml.entity.Weather;
import com.ml.entity.WeatherCountResult;

public interface WeatherCountRepository extends CrudRepository<WeatherCountResult, Integer> {
	@Query("select u from WeatherCountResult u where u.weatherType = ?1")
	WeatherCountResult findByType(String type);
}
