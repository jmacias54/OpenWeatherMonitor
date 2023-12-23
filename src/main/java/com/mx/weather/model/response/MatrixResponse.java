package com.mx.weather.model.response;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MatrixResponse {
	private double[][] result;
}
