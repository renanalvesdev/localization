package io.github.renanalvesdev.localization.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.renanalvesdev.localization.domain.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

	
	List<City> findByName(String name);
	
	//searching for city having name starting with requested string
	List<City> findByNameStartingWith(String name);
	
	//searching for city having name ending with requested string
	List<City> findByNameEndingWith(String name);
	
	// searching for city having name containing requested string
	List<City> findByNameContaining(String name);
	
	List<City> findByHabitants(Long habitants);

	
}
