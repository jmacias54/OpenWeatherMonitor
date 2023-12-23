package com.mx.weather.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Weather {

	private int id;
	private String main;
	private String description;
	private String icon;

}
