package com.example.demo.resources;

import java.util.ArrayList;
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

//	@RequestMapping("/{movieId}")
//	public Rating getRating(@PathVariable("movieId") String movieId) {
//		return new Rating("gasd", 3);
//	}

	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) throws InterruptedException {
		System.out.println("Putting thread to sleep for 1 minute");
		Thread.sleep(100000);
		
		List<Rating> allRatings = Arrays.asList(
				new Rating("1", "1", 2),
				new Rating("1", "2", 3),
				new Rating("1", "3", 2),
				new Rating("2", "4", 6),
				new Rating("2", "5", 4),
				new Rating("2", "6", 2),
				new Rating("3", "7", 1),
				new Rating("3", "8", 2),
				new Rating("3", "8", 2)
				
		);
		
		UserRating userRating = new UserRating();
		List<Rating> ratingForUser = new ArrayList<Rating>();
		
		for(Rating rating : allRatings) {
			if(rating.getUserId().equals(userId)) {
				ratingForUser.add(rating);
			}
			
			userRating.setUserRatings(ratingForUser);
		}

		return userRating;

	}

}
