package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.entity.Movie;
import com.example.ticketbookingsystem.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private MovieServiceInterface movieService;

    @Autowired
    public MovieController(MovieServiceInterface mService){
        movieService = mService;
    }

    @GetMapping("/movies")
    public List<Movie> findAll(){
        return  movieService.findAll();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovies(@PathVariable int movieId){
        Movie movie = movieService.findById(movieId);

        if(movie == null){
            throw new RuntimeException("Movie id not found: " + movieId);
        }
        return movie;
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        movie.setId(0);
        Movie movieDB = movieService.update(movie);
        return movieDB;
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie){
        Movie movieDB = movieService.update(movie);
        return movieDB;
    }

    @DeleteMapping("/movies/{movieId}")
    public String deleteMovie(@PathVariable int movieId){
        Movie movie = movieService.findById(movieId);

        if(movie == null){
            throw new RuntimeException("Movie id not found: " + movieId);
        }
        movieService.deleteById(movieId);

        return "The movie with ID " + movieId + " has been deleted.";
    }

}
