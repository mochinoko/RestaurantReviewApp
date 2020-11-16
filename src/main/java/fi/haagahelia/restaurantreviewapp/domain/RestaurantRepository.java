package fi.haagahelia.restaurantreviewapp.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
	
	
	List<Restaurant> findByRestaurantName(String restaurantName);
	
	/*
	 * @Query(value="select * from Restaurant r where r.restaurantName like %:keyword% or r.category.name like %:keyword%", nativeQuery= true)
	
	List<Restaurant> findByKeyword(@Param("keyword") String keyword);
	 */
}
