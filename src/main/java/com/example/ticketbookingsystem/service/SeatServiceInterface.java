package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.entity.Seat;

import java.util.List;

public interface SeatServiceInterface {

    List<Seat> findAll();

    Seat findById(int id);

    Seat update(Seat seat);

    void deleteById(int id);

}
