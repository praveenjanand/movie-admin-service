package com.group5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group5.dto.GetMoviesRequest;
import com.group5.dto.Movies;
import com.group5.repo.MoviesRepository;


@Service
public class MoviesService {
	
	@Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> listMoviesForDate(GetMoviesRequest reqObj) {
    	List<Movies> moviesList = moviesRepository.findByDate(reqObj.getDate());
    	return moviesList;
    }


	public String addMovie(Movies reqObj) {
		moviesRepository.save(reqObj);
		return "successfully Added Movie for the date: "+reqObj.getDate();
	}



	public String deleteMovie(Movies reqObj) {
		
		Movies reqObj2 = moviesRepository.findByTitle(reqObj.getTitle());
		moviesRepository.delete(reqObj2);
		return "successfully Deleted Movie ";
	}

  


}
