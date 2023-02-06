package io.github.renanalvesdev.localization.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.renanalvesdev.localization.domain.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
