package com.mx.weather.service.impl;

import com.mx.weather.config.ConfigProperties;
import com.mx.weather.contract.Mapper;
import com.mx.weather.exception.ItemNotFoundException;
import com.mx.weather.model.entity.WeatherInfo;
import com.mx.weather.model.response.CityWeatherInfoResponse;
import com.mx.weather.repository.WeatherInfoRepository;
import com.mx.weather.rest.OpenWeathermapApi;
import com.mx.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

	private final WeatherInfoRepository weatherInfoRepository;
	private final OpenWeathermapApi openWeathermapApi;
	private final ConfigProperties configProperties;
	private final Mapper<WeatherInfo, CityWeatherInfoResponse> weatherInfoToCityWeatherInfoResponseMapper;

	@Override
	public CityWeatherInfoResponse findCityInfoResponse(String city) {
		try {
			WeatherInfo weatherInfo = this.openWeathermapApi.getWeatherForCity(
				city,
				configProperties.getOpenWeatherMapToken()
			);
			weatherInfo.setId(null);

			weatherInfo = this.weatherInfoRepository.save(weatherInfo);

			return this.weatherInfoToCityWeatherInfoResponseMapper.map(weatherInfo);

		} catch(Exception e) {
			return handleError(city, e);
		}

	}

	private CityWeatherInfoResponse handleError(String city, Exception exception) {
		Optional<WeatherInfo> weatherInfo = this.weatherInfoRepository.findByName(city);

		if(weatherInfo.isPresent())
			return this.weatherInfoToCityWeatherInfoResponseMapper.map(weatherInfo.get());
		else
			throw new ItemNotFoundException("No se encontro informacion de la ciudad ");
	}

	public List<CityWeatherInfoResponse> findLatestDistinctNames() {
		List<WeatherInfo> distinctNames = weatherInfoRepository.findDistinctTop10ByNameIsNotNullOrderByDtDesc();


		return distinctNames.stream()
			.map(this.weatherInfoToCityWeatherInfoResponseMapper::map)
			.collect(
				Collectors.toList());
	}
}
