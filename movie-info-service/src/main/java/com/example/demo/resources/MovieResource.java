package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
	
		
		List<Movie> allMovies = Arrays.asList(
				new Movie("1", "Jaws", "About a Shark"),
				new Movie("2", "Predator", "Scary Aliens"),
				new Movie("3", "Terminator", "Determined Robots"),
				new Movie("4", "The Fly", "He is a scientist"),
				new Movie("5", "Starwars", "Set in space"),
				new Movie("6", "Jaws II", "Not as good"),
				new Movie("7", "Empire Strikes Back", "Darker Better"),
				new Movie("8", "Apocalypto", "Mel Gibsons best"),
				new Movie("9", "Chappie", "Made in South Africa")
				
		);
		Movie movieToReturn = null;
		for(Movie movie : allMovies) {
			if(movie.getMovieId().equals(movieId)){
				movieToReturn = movie;
				break;
			}
			
			
		}
		return movieToReturn;
		
	}
}
