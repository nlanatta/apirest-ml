package com.ml.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "weather_value")
	private String weatherValue;

	@Column(name = "day_value")
	private int dayValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeatherValue() {
		return weatherValue;
	}

	public void setWeatherValue(String weatherValue) {
		this.weatherValue = weatherValue;
	}

	public int getDayValue() {
		return dayValue;
	}

	public void setDayValue(int dayValue) {
		this.dayValue = dayValue;
	}
}
