package com.mx.weather.model.mappers;

import com.mx.weather.contract.Mapper;
import com.mx.weather.model.entity.WeatherInfo;
import com.mx.weather.model.response.CityWeatherInfoResponse;
import org.springframework.stereotype.Component;


@Component
public class WeatherInfoToCityWeatherInfoResponseMapper implements Mapper<WeatherInfo, CityWeatherInfoResponse> {
	@Override
	public CityWeatherInfoResponse map(WeatherInfo input) {
		return new CityWeatherInfoResponse(
			input.getId(),
			input.getWeather(),
			input.getMain(),
			input.getVisibility(),
			input.getWind(),
			input.getName()
		);

	}
}
