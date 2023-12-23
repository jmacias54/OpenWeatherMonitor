package com.mx.weather.service;

import com.mx.weather.model.request.MatrixRequest;
import com.mx.weather.model.response.MatrixResponse;

public interface MatrixService {

	MatrixResponse multiplyMatrices(MatrixRequest request);
}
