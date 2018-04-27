package com.qa.business.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

public class MovieDBRepository implements IMovieRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllMovies() {
		LOGGER.info("MovieDBRepository getAllMovies");
		Query query = manager.createQuery("Select m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>)query.getResultList();

		return util.getJSONForObject(movies);
	}
	
	@Override
	public String getAMovie(long id)
	{
		LOGGER.info("MovieDBRepository getAMovie");
		return util.getJSONForObject(manager.find(Movie.class, id));
	}
	
	@Override
	public String createMovie(String movie)
	{
		LOGGER.info("MovieDBRepository createMovie");
		manager.persist(util.getObjectForJSON(movie, Movie.class));
		return "Successfully added";
	}
	
	@Override
	public String deleteMovie(long id)
	{
		LOGGER.info("In MovieDBRepository deleteMovie");
		Movie mv = manager.find(Movie.class, id);
		if(mv != null)
		{
			manager.remove(manager.find(Movie.class, id));
			return "Deleted successfully";
		}
		else return "Movie not found";

		
	}

}
