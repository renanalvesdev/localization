package io.github.renanalvesdev.localization.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.renanalvesdev.localization.domain.entity.City;
import io.github.renanalvesdev.localization.domain.repository.CityRepository;
import io.github.renanalvesdev.localization.domain.repository.specs.CitySpecs;

@Service
public class CityService {

	private CityRepository repository;
	
	
	public CityService(CityRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public void save() {
		var city = new City(1L, "Lisbon", 500000L );
		repository.save(city);
	}
	
	public void list() {
		//repository.findAll().forEach(System.out::println);
		//repository.findByName("Porto").forEach(System.out::println);
		//repository.findByNameStartingWith("P").forEach(System.out::println);
		//repository.findByNameLike("P%", Sort.by("habitants") ).forEach(System.out::println);
		Pageable pageable = PageRequest.of(0, 2);
		repository.findByNameLikePageable("P%",  pageable).forEach(System.out::println);
	}
	
	public List<City> dynamicFilter(City city) {
		
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
		
		Example<City> example = Example.of(city, matcher);
		
		return repository.findAll(example);
	}
	
	public void listByNameSpec() {
		Specification<City> spec = CitySpecs.nameEqual("Porto").and(CitySpecs.habitantsGreaterThan(1000));
		repository.findAll(spec).forEach(System.out::println);
	}
	
	
	
}
