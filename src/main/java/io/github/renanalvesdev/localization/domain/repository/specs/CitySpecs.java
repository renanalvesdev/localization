package io.github.renanalvesdev.localization.domain.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import io.github.renanalvesdev.localization.domain.entity.City;

public class CitySpecs {

	
	public static Specification<City> nameEqual(String name){
		return (root, query, cb) -> cb.equal(root.get("name"), name);
	}
	
	public static Specification<City> habitantsGreaterThan(Long value){
		return (root, query, cb) -> cb.greaterThan(root.get("habitants"), value);
	}
	
}
