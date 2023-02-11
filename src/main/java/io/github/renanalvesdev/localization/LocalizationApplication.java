package io.github.renanalvesdev.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.renanalvesdev.localization.domain.entity.City;
import io.github.renanalvesdev.localization.domain.service.CityService;

@SpringBootApplication
public class LocalizationApplication implements CommandLineRunner{

	
	@Autowired
	CityService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		//saveCity();
		//service.list();
		City city = new City(null, "porto", null);
		service.dynamicFilter(city).forEach(System.out::println);
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LocalizationApplication.class, args);
	}


}
