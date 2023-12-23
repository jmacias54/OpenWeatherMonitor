package com.mx.weather.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Main {
	private double temp;
	@JsonProperty("feels_like")
	private double feelsLike;

	@JsonProperty("temp_min")
	private double tempMin;

	@JsonProperty("temp_max")
	private double tempMax;

	private int pressure;
	private int humidity;

	@JsonProperty("sea_level")
	private int seaLevel;

	@JsonProperty("grnd_level")
	private int grndLevel;
}
