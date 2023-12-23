package com.mx.weather.controller;

import com.mx.weather.model.request.MatrixRequest;
import com.mx.weather.model.response.MatrixResponse;
import com.mx.weather.service.MatrixService;
import com.mx.weather.util.Constants;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = Constants.MATRIX_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MatrixOperationsController {

	private final MatrixService matrixService;

	@PostMapping(path = "/multiply", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MatrixResponse> multiply(@RequestBody MatrixRequest request) {
		return ResponseEntity.ok(this.matrixService.multiplyMatrices(request));
	}
}
