package com.mx.weather.contract;

public interface Mapper<From, To> {
	To map(From input);
}

