package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserRatingInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name="USER_RATING_INFO_BREAK", fallbackMethod="getFallbackUserRating")
	//@Bulkhead(name = "USER_RATING_INFO_BULKHEAD", fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);
	}
	
	public UserRating getFallbackUserRating(String userId, Exception ex) {
		
		System.out.println("Entered getFallbackUserRating");
		
		UserRating userRating = new UserRating();
		userRating.setUserRatings(Arrays.asList(new Rating("1", 0)));
		return userRating;
		
	}
	

}
