package com.mx.weather.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Sys {

	private int type;
	private int id;
	private String country;
	private long sunrise;
	private long sunset;
}
