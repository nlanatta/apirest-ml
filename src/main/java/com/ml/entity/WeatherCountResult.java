package com.ml.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherCountResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String weatherType;

	private String weatherValue;

	private int dayCountValue;

	public String getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}

	public String getWeatherValue() {
		return weatherValue;
	}

	public void setWeatherValue(String weatherValue) {
		this.weatherValue = weatherValue;
	}

	public int getDayCountValue() {
		return dayCountValue;
	}

	public void setDayCountValue(int dayCountValue) {
		this.dayCountValue = dayCountValue;
	}
}
