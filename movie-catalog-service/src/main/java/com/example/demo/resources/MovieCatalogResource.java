package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;
import com.example.demo.models.UserCatalog;
import com.example.demo.models.UserRating;
import com.example.demo.service.MovieInfo;
import com.example.demo.service.UserRatingInfo;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
@RequestMapping("/catalog")
@Bulkhead(name = "CATALOG_BULKHEAD", fallbackMethod = "getFallbackCatalog")
public class MovieCatalogResource {

//	@Autowired
//	private WebClient.Builder webClientBuilder;
	// Get all rated movie IDs

	@Autowired
	private MovieInfo movieInfo;

	@Autowired
	private UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public UserCatalog getCatalog(@PathVariable("userId") String userId) {
		System.out.println("Entered getCatalog");
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1234", 4),
//				new Rating("4646", 7)
//		);

		UserCatalog userCatalog = new UserCatalog();

		UserRating ratings = userRatingInfo.getUserRating(userId);

		List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
		// For each movie ID, call movie info service and get details
		for (Rating rating : ratings.getUserRatings()) {
			Movie movie = movieInfo.getMovieInfo(rating.getMovieId());

//			Movie movie = webClientBuilder.build()
//			.get()
//			.uri("http://localhost:8081/movies/" + rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();

			// Put them together
			catalogItems.add(new CatalogItem(movie.getMovieName(), movie.getMovieDesc(), rating.getRating()));
		}

		userCatalog.setCatalogItems(catalogItems);

		return userCatalog;

	}

	public UserCatalog getFallbackCatalog(String userId, Exception ex) {

		System.out.println("Entered getFallbackCatalog");

		return new UserCatalog();

	}

}
