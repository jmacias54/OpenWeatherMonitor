package com.mx.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.mx.weather"
})
public class WeatherInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherInfoApplication.class, args);
	}

}
