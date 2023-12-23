package com.mx.weather.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MatrixRequest {

	private final double[][] matrixA;
	private final double[][] matrixB;

}
