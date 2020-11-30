package fi.haagahelia.restaurantreviewapp.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
	
	
	List<Restaurant> findByRestaurantName(String restaurantName);
	
	/*Search by restaurant name*/
	
	@Query(
			value="SELECT * FROM Restaurant r WHERE r.restaurant_name LIKE %:keyword% or r.address LIKE %:keyword% or r.review LIKE %:keyword% ",
			nativeQuery= true)

	List<Restaurant> findByKeyword(@Param("keyword") String keyword);
}
