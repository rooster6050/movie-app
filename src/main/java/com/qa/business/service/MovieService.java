package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMovieRepository;

public class MovieService implements IMovieService {
	
	@Inject private IMovieRepository repo;

	@Override
	public String getAllMovies() {
		return repo.getAllMovies();
	}
	
	@Override
	public String getAMovie(long id) {
		return repo.getAMovie(id);
	}
	
	@Override
	public String createMovie(String mv)
	{
		return repo.createMovie(mv);
	}
	
	@Override
	public String deleteMovie(long id)
	{
		return repo.deleteMovie(id);
	}

}
