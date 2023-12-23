package com.mx.weather.model.response;

import com.mx.weather.model.entity.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Accessors(chain = true)
public class CityWeatherInfoResponse {

	@Id
	private final String id;
	private final List<Weather> weather;
	private final Main main;
	private final int visibility;
	private final Wind wind;
	private final String name;

}
