package com.weather.weatherdataproducer.dto;

import java.time.LocalDateTime;

public final class WeatherDataDto {

	
	private final LocalDateTime timestamp;

	private final String location;

	private final int temperature;

	private final String observatory;

	public WeatherDataDto(LocalDateTime timestamp, String location, int temperature, String observatory) {

		this.timestamp = timestamp;
		this.temperature = temperature;
		this.location = location;
		this.observatory = observatory;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getLocation() {
		return location;
	}

	public int getTemperature() {
		return temperature;
	}

	public String getObservatory() {
		return observatory;
	}

	public String getFormattedMessage() {
		return timestamp + "|" + location + "|" + temperature + "|" + observatory;

	}
}
