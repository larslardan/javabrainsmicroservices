package com.example.demo.models;

public class Movie {
	
	private String movieId;
	private String movieName;
	private String movieDesc;

	public Movie() {
		super();
	}

	public Movie(String movieId, String movieName, String movieDesc) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	
	

}
