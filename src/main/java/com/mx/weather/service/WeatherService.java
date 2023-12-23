package com.mx.weather.service;

import com.mx.weather.model.response.CityWeatherInfoResponse;

import java.util.List;

public interface WeatherService {

	CityWeatherInfoResponse findCityInfoResponse(String city);

	List<CityWeatherInfoResponse> findLatestDistinctNames();
}
