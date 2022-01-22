package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Movie;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;

	//@CircuitBreaker(name="MOVIE_INFO_BREAK", fallbackMethod="getFallbackMovieInfo")
	public Movie getMovieInfo(String movieId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + movieId, Movie.class);

	}
	
	public Movie getFallbackMovieInfo(String movieId, Exception ex) {
		
		System.out.println("Entered getFallbackMovieInfo");
		
		return new Movie(movieId, "Details not available", "Details not available");
		
	}

}
