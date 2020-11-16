package fi.haagahelia.restaurantreviewapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.restaurantreviewapp.domain.Category;
import fi.haagahelia.restaurantreviewapp.domain.CategoryRepository;
import fi.haagahelia.restaurantreviewapp.domain.Restaurant;
import fi.haagahelia.restaurantreviewapp.domain.RestaurantRepository;
import fi.haagahelia.restaurantreviewapp.domain.User;
import fi.haagahelia.restaurantreviewapp.domain.UserRepository;

@SpringBootApplication
public class RestaurantReviewAppApplication {
	private static final Logger log = LoggerFactory.getLogger(RestaurantReviewAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RestaurantRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			/*
			log.info("save a couple of restaurants");
			repository.deleteAll();
			crepository.deleteAll();
			urepository.deleteAll();
			
			crepository.save(new Category("Indian"));
			crepository.save(new Category("Japanese"));
			crepository.save(new Category("American"));
			crepository.save(new Category("Vietnamise"));
			crepository.save(new Category("Thai"));
			crepository.save(new Category("Finnish"));
			crepository.save(new Category("Italian"));
			crepository.save(new Category("Spanish"));
			
			Restaurant r1 = new Restaurant("Ravintola Perunamuusi", "Helsinginkatu 12",  "Good food and service. There were many tourists. You can enjoy reindeer meat from Lapland.", 4, crepository.findByName("Finnish").get(0) );
			Restaurant r2 = new Restaurant("Sushi sho", "Liisankatu 52", "I enjoyed Authentic japanese sushi. Omakase set was 40euro per person", 5, crepository.findByName("Japanese").get(0) );
			Restaurant r3 = new Restaurant("Street Thai", "Herukkukatu 2", "Pattai was real thai style. Papaya salad was so fresh and tasty.", 5, crepository.findByName("Thai").get(0) );
			
			repository.save(r1);
			repository.save(r2);
			repository.save(r3);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("yuki", "$2a$10$RCsJXrLwXF5P76aCLN1hAen776G9D2KRWlpeXQullGfIpycvwienC", "USER"); //pw: useryuki
			User user3 = new User("nanashiadmin", "$2a$10$H/jl4Xnd7ZrYtE.4oDzpPu8h/d4XRW87qzViol8cvYczeJmgo8Oha", "ADMIN"); // pw: nanashinogonbei
			User user4 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			
			log.info("fetch all students");
			for (Restaurant restaurant : repository.findAll()) {
				log.info(restaurant.toString());
			}
			*/
		};
		
	}

}
