package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.dao.MovieRepository;
import com.example.ticketbookingsystem.entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieServiceInterface {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository mDAO){
        movieRepository = mDAO;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {

        Optional<Movie> result = movieRepository.findById(id);

        Movie movie = null;

        if(result.isPresent()){
            movie = result.get();
        }else {
            throw new RuntimeException("Did not find movie id: " + id);
        }

        return movie;
    }

    @Transactional
    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }
}
