package com.ml.repository;

import org.springframework.data.repository.CrudRepository;

import com.ml.entity.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Integer> {

}
