package com.mx.weather.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "city_info")
public class WeatherInfo {

	@Id
	private String id;
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private Sys sys;
	private String timezone;
	private String name;

}
