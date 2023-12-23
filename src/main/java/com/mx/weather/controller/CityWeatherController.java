package com.mx.weather.controller;

import com.mx.weather.model.response.CityWeatherInfoResponse;
import com.mx.weather.service.WeatherService;
import com.mx.weather.util.Constants;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constants.WEATHER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CityWeatherController {

	private final WeatherService weatherService;

	@GetMapping(path = "/findByCity")
	public ResponseEntity<CityWeatherInfoResponse> findByCity(@RequestParam("city") String city) {
		return ResponseEntity.ok(this.weatherService.findCityInfoResponse(city));
	}

	@GetMapping(path = "/lastest")
	public ResponseEntity<List<CityWeatherInfoResponse>> findLatestDistinctNames() {
		return ResponseEntity.ok(this.weatherService.findLatestDistinctNames());
	}
}
