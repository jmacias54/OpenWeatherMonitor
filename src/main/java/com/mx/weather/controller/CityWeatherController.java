package com.mx.weather.controller;

import com.mx.weather.util.Constants;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = Constants.WEATHER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CityWeatherController {


	@GetMapping("/{city}")
	@ApiOperation("Get a greeting message")
	public String findCityWeather(@PathVariable("city") String city) {
		return String.format("Hello, World {%s}!", city);
	}

}
