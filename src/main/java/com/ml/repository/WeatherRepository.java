package com.ml.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ml.entity.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Integer> {
	@Query("select u from Weather u where u.dayValue = ?1")
	Weather findByDay(Integer dia);
	
	@Query("select u from Weather u where u.weatherValue = ?1")
	Weather findByValue(String value);
}
