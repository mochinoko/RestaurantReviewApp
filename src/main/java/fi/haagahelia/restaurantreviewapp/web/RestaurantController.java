package fi.haagahelia.restaurantreviewapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.restaurantreviewapp.domain.Category;
import fi.haagahelia.restaurantreviewapp.domain.CategoryRepository;
import fi.haagahelia.restaurantreviewapp.domain.Restaurant;
import fi.haagahelia.restaurantreviewapp.domain.RestaurantRepository;
import fi.haagahelia.restaurantreviewapp.domain.SignupForm;
import fi.haagahelia.restaurantreviewapp.service.RestaurantService;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/restaurantlist")
	public String restaurantList(Model model) {
		model.addAttribute("restaurants", repository.findAll());
		
		return "restaurantlist";
	}
	
	//Search restaurant by keyword
	
	@GetMapping("/restaurants")
	public String getRestaurants(Model model, String keyword) {
		if(keyword != null ) {
			model.addAttribute("restaurants", restaurantService.findByKeyword(keyword));
		} else {
			model.addAttribute("restaurants", restaurantService.getRestaurants());
		}
		return "restaurantlist";
	}

	
	//Add new restaurant
	
	@RequestMapping(value="/add")
	public String addRestaurant(Model model) {
		model.addAttribute("restaurant", new Restaurant());
		model.addAttribute("categories", crepository.findAll());
		return "addrestaurant";
	}
	
	//Save new restaurant
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(Restaurant restaurant) {
		repository.save(restaurant);
			return "redirect:restaurantlist";
	}

	
	//Delete restaurant
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public String deleteRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		repository.deleteById(restaurantId);
		return  "redirect:../restaurantlist";
	}
	
	//modify restaurant
	
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String editRestaurant(@PathVariable("id") Long restaurantId, Model model) {
    	model.addAttribute("restaurant", repository.findById(restaurantId));
    	model.addAttribute("categories", crepository.findAll());
    	return "modifyrestaurant";
    }   

 	@GetMapping(value = "/saveEdit")
	public String saveEdit(Restaurant restaurant,  Category category) {
		repository.save(restaurant);
		crepository.save(category);
		return "redirect:restaurantlist";
	}
 	

	// REST --> editing books
	@GetMapping(value="/editId/{id}")
	public @ResponseBody Optional<Restaurant> editRestaurantRest(@PathVariable("id") Long restaurantId, Model model) {
		repository.findById(restaurantId);
		model.addAttribute("categories", crepository.findAll());
		return repository.findById(restaurantId);
	}

}
