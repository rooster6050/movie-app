package com.qa.business.repository;

public interface IMovieRepository {
	
	String getAllMovies();
	
	String getAMovie(long id);
	
	String createMovie(String movie);

	String deleteMovie(long id);

}
