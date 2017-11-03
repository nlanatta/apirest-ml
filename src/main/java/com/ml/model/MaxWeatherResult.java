package com.ml.model;

public class MaxWeatherResult {
	private String weatherType;

	private String weather;

	private int amount;

	public String getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}

	public String getWeatherValue() {
		return weather;
	}

	public void setWeatherValue(String weatherValue) {
		this.weather = weatherValue;
	}

	public int getDayCountValue() {
		return amount;
	}

	public void setDayCountValue(int dayCountValue) {
		this.amount = dayCountValue;
	}
}
