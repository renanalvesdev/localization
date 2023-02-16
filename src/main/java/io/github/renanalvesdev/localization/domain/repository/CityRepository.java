package io.github.renanalvesdev.localization.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import io.github.renanalvesdev.localization.domain.entity.City;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City>{

	
	List<City> findByName(String name);
	
	//searching for city having name starting with requested string
	List<City> findByNameStartingWith(String name);
	
	@Query(" select c from City c where upper(c.name) like upper(?1)")
	List<City> findByNameLike(String name, Sort sort);
	
	@Query(" select c from City c where upper(c.name) like upper(?1)")
	Page<City> findByNameLikePageable(String name, Pageable pageable);
	
	//searching for city having name ending with requested string
	List<City> findByNameEndingWith(String name);
	
	// searching for city having name containing requested string
	List<City> findByNameContaining(String name);
	
	List<City> findByHabitants(Long habitants);

	
}
