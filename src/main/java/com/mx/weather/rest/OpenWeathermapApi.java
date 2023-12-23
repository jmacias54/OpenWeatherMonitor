package com.mx.weather.rest;


import com.mx.weather.model.entity.WeatherInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OpenWeathermapApi {

	private final RestTemplate restTemplate;

	public WeatherInfo getWeatherForCity(String city, String apiKey) {
		// Construye la URL con la ciudad y la clave de la API
		String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

		// Realiza la solicitud GET y devuelve la respuesta como cadena
		return restTemplate.getForObject(apiUrl, WeatherInfo.class);
	}
}
