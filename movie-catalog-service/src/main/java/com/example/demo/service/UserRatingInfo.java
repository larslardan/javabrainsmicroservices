package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;

@Service
public class UserRatingInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public UserRating getUserRating(String userId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);
	}
	
	public UserRating getFallbackUserRating(String userId) {

		UserRating userRating = new UserRating();
		userRating.setUserRatings(Arrays.asList(new Rating("0", 0)));
		return userRating;
		
	}
	

}
