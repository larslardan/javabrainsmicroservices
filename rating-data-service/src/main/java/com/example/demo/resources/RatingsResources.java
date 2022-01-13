package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResources {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("gasd", 3);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String movieId) {
		
		
		
		
		UserRating userRating = new UserRating();
		userRating.setUserRatings(Arrays.asList(
				new Rating("1234", 2),
				new Rating("3452", 7)
				));
		return userRating;
		
	}
	
}
