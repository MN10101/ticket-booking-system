package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.entity.Showtime;

import java.util.List;

public interface ShowtimeServiceInterface {

    List<Showtime> findAll();

    Showtime findById(int id);

    Showtime update(Showtime showtime);

    void deleteById(int id);
}
