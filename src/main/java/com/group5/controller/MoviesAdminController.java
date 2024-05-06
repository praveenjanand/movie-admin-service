package com.group5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group5.dto.AddMoviesRequest;
import com.group5.dto.GetMoviesRequest;
import com.group5.dto.Movies;
import com.group5.service.AuthService;
import com.group5.service.MoviesService;

@RestController
@RequestMapping("/api/v1/movie-admin")
public class MoviesAdminController {
	
	 @Autowired
	 private MoviesService moviesService;
	 
    @Autowired
    private AuthService authService;

	    @PostMapping("/findMoviesByDate")
	    public ResponseEntity<List<Movies>> findMoviesByDate(@RequestBody GetMoviesRequest reqObj, @RequestHeader("Authorization") String authorizationHeader) {
	    	List<Movies> moviesList = moviesService.listMoviesForDate(reqObj);
	        return ResponseEntity.ok(moviesList);
	    }

	    @PostMapping("/addMovie")
	    public ResponseEntity<String> addMovie(@RequestBody Movies reqObj) {
	        String moviesList = moviesService.addMovie(reqObj);
	        return ResponseEntity.ok(moviesList);
	    }
	    
	    @PostMapping("/deleteMovie")
	    public ResponseEntity<String> deleteMovie(@RequestBody Movies reqObj) {
	        String moviesList = moviesService.deleteMovie(reqObj);
	        return ResponseEntity.ok(moviesList);
	    }
	    
	  
}
