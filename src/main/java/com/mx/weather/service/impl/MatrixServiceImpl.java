package com.mx.weather.service.impl;

import com.mx.weather.model.request.MatrixRequest;
import com.mx.weather.model.response.MatrixResponse;
import com.mx.weather.service.MatrixService;
import org.springframework.stereotype.Service;

@Service
public class MatrixServiceImpl implements MatrixService {

	public MatrixResponse multiplyMatrices(MatrixRequest request) {
		double[][] matrixA = request.getMatrixA();
		double[][] matrixB = request.getMatrixB();

		// Verificar si las matrices son multiplicables
		if(matrixA[0].length != matrixB.length) {
			throw new IllegalArgumentException("No es posible multiplicar las matrices proporcionadas.");
		}

		int m = matrixA.length;
		int n = matrixA[0].length;
		int p = matrixB[0].length;

		double[][] resultMatrix = new double[m][p];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < p; j++) {
				for(int k = 0; k < n; k++) {
					resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}

		return new MatrixResponse().setResult(resultMatrix);
	}
}
