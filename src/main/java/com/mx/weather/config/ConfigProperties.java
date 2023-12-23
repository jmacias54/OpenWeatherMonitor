package com.mx.weather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ConfigProperties {

	
	@Value("${weather.api.token}")
	private String openWeatherMapToken;
}