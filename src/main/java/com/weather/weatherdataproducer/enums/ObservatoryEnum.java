package com.weather.weatherdataproducer.enums;



public enum ObservatoryEnum {

	AU(Temperature.CELSIUS, "km"), 
	US(Temperature.FAHRENHEIT, "miles"), 
	FR(Temperature.KELVIN, "m"), 
	ALL_OTHERS(Temperature.KELVIN, "km");

	private Temperature temperature;
	
	private String distance;
	
	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}


	ObservatoryEnum(Temperature temperature, String distance) {
		this.temperature = temperature;
		this.distance = distance;
	}

	public static ObservatoryEnum fromString(String observatoryEnumText) {
		for (ObservatoryEnum observatoryEnum : ObservatoryEnum.values()) {
			if (observatoryEnum.name().equalsIgnoreCase(observatoryEnumText)) {
				return observatoryEnum;
			}
		}

		throw new IllegalArgumentException("No constant with observatoryEnumText " + observatoryEnumText + " found");
	}
}
