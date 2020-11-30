package fi.haagahelia.restaurantreviewapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.restaurantreviewapp.domain.Restaurant;
import fi.haagahelia.restaurantreviewapp.domain.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	//Return list of restaurants
	
	public List<Restaurant> getRestaurants(){
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	
	//Get restaurant by keyword
	
	public List<Restaurant> findByKeyword(String keyword){
		return restaurantRepository.findByKeyword(keyword);
	}
	
}
