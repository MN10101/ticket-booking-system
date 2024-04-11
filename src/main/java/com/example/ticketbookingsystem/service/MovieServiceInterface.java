package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {

    List<Movie> findAll();

    Movie findById(int id);

    Movie update(Movie movie);

    void deleteById(int id);
}
