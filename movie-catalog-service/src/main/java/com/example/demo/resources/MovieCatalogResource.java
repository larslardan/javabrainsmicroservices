package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	//Get all rated movie IDs
	
	
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1234", 4),
//				new Rating("4646", 7)
//		);
		
		UserRating ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);
		
		List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
		//For each movie ID, call movie info service and get details
		for (Rating rating : ratings.getUserRatings()) {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
			
//			Movie movie = webClientBuilder.build()
//			.get()
//			.uri("http://localhost:8081/movies/" + rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();
			
			//Put them together
			catalogItems.add(new CatalogItem(movie.getMovieName(), "Robots", rating.getRating()));
		}
		
		return catalogItems;
		
		
		
	}

}
