package com.qa.business.service;

public interface IMovieService {
	
	String getAllMovies();
	
	String getAMovie(long id);
	
	String createMovie(String movie);

	String deleteMovie(long id);

}
