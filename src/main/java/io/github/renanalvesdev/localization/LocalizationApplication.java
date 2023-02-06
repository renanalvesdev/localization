package io.github.renanalvesdev.localization;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.renanalvesdev.localization.domain.entity.City;
import io.github.renanalvesdev.localization.domain.repository.CityRepository;

@SpringBootApplication
public class LocalizationApplication implements CommandLineRunner{

	
	@Autowired
	CityRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//saveCity();
		listCities();
		
	}
	
	@Transactional
	void saveCity() {
		var city = new City(1L, "Lisbon", 500000L );
		repository.save(city);
	}
	
	void listCities() {
		repository.findAll().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LocalizationApplication.class, args);
	}


}
