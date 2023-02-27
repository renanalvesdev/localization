package io.github.renanalvesdev.localization.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.renanalvesdev.localization.domain.entity.City;
import io.github.renanalvesdev.localization.domain.repository.projections.CityProjection;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City>{

	
	//if we put * or some property using the correct return, everything works fine
	//but if we put more than one property with entity as list return, will break
	//to solve this, we can use Projections.
	@Query(nativeQuery =true, value="select c.name from tb_city as c where c.name =:name")
	List<String> findByNameNativeSQL(@Param("name") String name);
	
	
	//wont work because projection doesnt have id_city alias.
	//instead , we only have id. so we should apply an alias to id property
	@Query(nativeQuery =true, value="select c.id_city as id, c.name from tb_city as c where c.name =:name")
	List<CityProjection> findByNameNativeSQLProjection(@Param("name") String name);
	
	
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
