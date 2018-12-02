package com.movie.service;


import com.movie.dao.MovieDao;

public class MovieService {
	public Object queryMessageList(String search_text) {
		// TODO Auto-generated method stub
		MovieDao movieDao = new MovieDao();
		return movieDao.queryMovieList(search_text);
	}
}
