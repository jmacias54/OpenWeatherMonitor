package com.mx.weather.repository;

import com.mx.weather.model.entity.WeatherInfo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherInfoRepository extends MongoRepository<WeatherInfo, String> {

	Optional<WeatherInfo> findByName(String name);

	@Query(value = "{ }", sort = "{ _id : -1 }")
	List<WeatherInfo> findLatestDistinctNames(PageRequest pageRequest);

	default List<WeatherInfo> findLatestDistinctNames() {
		return findLatestDistinctNames(PageRequest.of(0, 10));
	}

	List<WeatherInfo> findDistinctTop10ByNameIsNotNullOrderByDtDesc();

}
