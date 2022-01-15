package com.example.demo.models;

public class Rating {
	
	private String userId;
	private String movieId;
	private int rating;
	
	public Rating() {
		super();
	}
	public Rating(String userId, String movieId, int rating) {
		super();
		this.setUserId(userId);
		this.movieId = movieId;
		this.rating = rating;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
